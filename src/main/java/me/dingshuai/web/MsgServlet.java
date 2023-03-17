package me.dingshuai.web;

import jakarta.servlet.http.HttpServlet;
import me.dingshuai.pojo.Message;
import me.dingshuai.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/msg")
public class MsgServlet extends HttpServlet {
	@Autowired
	private MsgService msgService;

	// 增
	@RequestMapping("/addMsg")
	private String addMsg(@ModelAttribute("msg") Message msg, Model model) {
		System.out.println("msg = " + msg);
		if (msgService.leaveAMsg(msg) == 1) {
			return "redirect:/msg/showAllMsgsForUser";
		}
		model.addAttribute("error", "留言失败！");
		return "/error.html";
	}

	// 删
	@RequestMapping("/deleteMsg")
	private String deleteMsg(@RequestParam String msgId, Model model) {
		if (msgService.deleteMsg(Integer.parseInt(msgId)) == 1) {
			// 删留言
			return "redirect:/msg/showAllMsgsForAdmin";
		}
		model.addAttribute("error", "删除失败！");
		return "/error.html";
	}

	// 改
	@RequestMapping("/replyMsg")
	private String replyMsg(@ModelAttribute("msg") Message msg, Model model) {
		if (msg.getMsgReplyContent().equals("")) {
			msg.setMsgStatus("未回复");
		} else {
			msg.setMsgStatus("已回复");
		}

		if (msgService.replyMsg(msg) == 1) {
			return "redirect:/msg/showAllMsgsForAdmin";
		}

		model.addAttribute("error", "回复失败！");
		return "/error.html";
	}

	// 查一个
	@RequestMapping("/showOneMsgForReply")
	private String showMsgForReply(@RequestParam String msgId, Model model) {
		Message message = msgService.showOneMsg(Integer.parseInt(msgId));
		model.addAttribute("message", message);
		return "/manage/reply.jsp";
	}

	// 查所有
	@RequestMapping("/showAllMsgsForUser")
	private String showMsgForUser(Model model) {
		List<Message> messages = msgService.showAllMsgs();
		model.addAttribute("messages", messages);
		return "/guestbook.jsp";
	}

	@RequestMapping("/showAllMsgsForAdmin")
	private String showMsgForAdmin(Model model) {
		List<Message> messages = msgService.showAllMsgs();
		model.addAttribute("messages", messages);
		return "/manage/guestbook.jsp";
	}
}