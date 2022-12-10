package me.dingshuai.test;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.dingshuai.dao.TmessagesDao;
import me.dingshuai.dao.TusersDao;
import me.dingshuai.dao.impl.TmessagesDaoImpl;
import me.dingshuai.dao.impl.TusersDaoImpl;
import me.dingshuai.pojo.Tmessages;
import me.dingshuai.pojo.Tusers;

import java.io.IOException;

@WebServlet(name = "UpdateMsg", urlPatterns = "/updateMsg")
public class UpdateMsg extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 获取请求参数
		String msgId = request.getParameter("msgId");
		String msgSender = request.getParameter("msgSender");
		String msgContent = request.getParameter("msgContent");
		String msgReplyContent = request.getParameter("msgReplyContent");

		System.out.println(msgId + " " + msgSender + " " + msgContent + " " + msgReplyContent);

		// 创建 Tusers 对象
		Tmessages tm = new Tmessages();
		tm.setMsgId(Integer.parseInt(msgId));
		tm.setMsgSender(msgSender);
		tm.setMsgContent(msgContent);
		tm.setMsgStatus("已回复");
		tm.setMsgReplyContent(msgReplyContent);

		// 创建 TusersDao 对象
		TmessagesDao dao = new TmessagesDaoImpl();

		// 使用 TusersDao 的 add 方法添加用户
		dao.updateMsg(tm);

		// 重定向
		response.sendRedirect("manage/guestbook.jsp");
	}
}
