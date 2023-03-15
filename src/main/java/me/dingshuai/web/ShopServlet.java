package me.dingshuai.web;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import me.dingshuai.mapper.MsgMapper;
import me.dingshuai.mapper.UserMapper;
import me.dingshuai.pojo.Message;
import me.dingshuai.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopServlet extends HttpServlet {
	private final UserMapper userMapper;
	private final MsgMapper msgMapper;
	private final Message msg;

	public ShopServlet(UserMapper userMapper, MsgMapper msgMapper, Message msg) {
		this.userMapper = userMapper;
		this.msgMapper = msgMapper;
		this.msg = msg;
	}

	@RequestMapping("/addMsg")
	private String doAddMsg(@RequestParam String guestName, @RequestParam String guestTitle,
							@RequestParam String guestContent) {
		msg.setMsgSender(guestName);
		msg.setMsgTitle(guestTitle);
		msg.setMsgContent(guestContent);
		msgMapper.addMsg(msg);
		return "redirect:/shop/showMsg";
	}

	@RequestMapping("/showMsg")
	private String doShowMsg(HttpServletRequest request) {
		List<Message> messages = msgMapper.findAll();
		HttpSession session = request.getSession(false);
		session.setAttribute("messages", messages);
		return "redirect:/guestbook.jsp";
	}

	@RequestMapping("/manageMsg")
	private String doManageMsg(HttpServletRequest request) {

		List<Message> messages = msgMapper.findAll();
		HttpSession session = request.getSession(false);
		session.setAttribute("messages", messages);
		return "redirect:/manage/guestbook.jsp";

	}

	@RequestMapping("/delete")
	private String doDel(@RequestParam String userId, @RequestParam String msgId) {
		if (!userId.equals("null")) {
			userMapper.deleteById(Integer.parseInt(userId));
			return "redirect:/user/show";
		} else {
			msgMapper.deleteById(Integer.parseInt(msgId));
			return "redirect:/shop/manageMsg";
		}
	}

	@RequestMapping("/detail")
	private String doDetail(@RequestParam String userId, HttpServletRequest request) {

		User user = userMapper.findById(userId);
		request.setAttribute("user", user);
		return "forward:/manage/detail.jsp";

	}

	@RequestMapping("/reply")
	private String doReply(@RequestParam String msgId, HttpServletRequest request) {

		Message msg = msgMapper.findById(Integer.parseInt(msgId));
		request.setAttribute("msg", msg);
		return "forward:/manage/reply.jsp";

	}

	@RequestMapping("/updateMsg")
	private String doUpdateMsg(@RequestParam String msgId, @RequestParam String msgSender, @RequestParam String msgContent, @RequestParam String msgReplyContent) {
		msg.setMsgId(Integer.parseInt(msgId));
		msg.setMsgSender(msgSender);
		msg.setMsgContent(msgContent);

		if (msgReplyContent.equals("")) {
			msg.setMsgStatus("未回复");
		} else {
			msg.setMsgStatus("已回复");
		}
		msg.setMsgReplyContent(msgReplyContent);

		// 使用 UserMapper 的 add 方法添加用户
		msgMapper.updateMsg(msg);

		// 重定向
		return "redirect:/shop/manageMsg";
	}
}