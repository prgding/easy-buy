package me.dingshuai.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.dingshuai.mapper.MsgMapper;
import me.dingshuai.mapper.UserMapper;
import me.dingshuai.pojo.Messages;
import me.dingshuai.pojo.Users;
import me.dingshuai.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopServlet", urlPatterns = {"/shop/addMsg", "/shop/showMsg", "/shop/manageMsg", "/shop/delete", "/shop/detail", "/shop/reply", "/shop/updateMsg"})
public class ShopServlet extends HttpServlet {
	private UserMapper userMapper;
	private MsgMapper msgMapper;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		SqlSession sqlSession = SqlSessionUtil.open();
		userMapper = sqlSession.getMapper(UserMapper.class);
		msgMapper = sqlSession.getMapper(MsgMapper.class);
		String servletPath = request.getServletPath();
		switch (servletPath) {
			case "/shop/addMsg" -> doAddMsg(request, response);
			case "/shop/showMsg" -> doShowMsg(request, response);
			case "/shop/manageMsg" -> doManageMsg(request, response);
			case "/shop/delete" -> doDel(request, response);
			case "/shop/detail" -> doDetail(request, response);
			case "/shop/reply" -> doReply(request, response);
			case "/shop/updateMsg" -> doUpdateMsg(request, response);
		}
		sqlSession.commit();
		SqlSessionUtil.close(sqlSession);
	}

	private void doAddMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String guestName = request.getParameter("guestName");
		String guestTitle = request.getParameter("guestTitle");
		String guestContent = request.getParameter("guestContent");


		Messages tm = new Messages();
		tm.setMsgSender(guestName);
		tm.setMsgTitle(guestTitle);
		tm.setMsgContent(guestContent);
		msgMapper.addMsg(tm);

		response.sendRedirect(request.getContextPath() + "/shop/showMsg");


	}

	private void doShowMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<Messages> messages = msgMapper.findAll();
		HttpSession session = request.getSession(false);
		session.setAttribute("messages", messages);
		response.sendRedirect(request.getContextPath() + "/guestbook.jsp");


	}

	private void doManageMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<Messages> messages = msgMapper.findAll();
		HttpSession session = request.getSession(false);
		session.setAttribute("messages", messages);
		response.sendRedirect(request.getContextPath() + "/manage/guestbook.jsp");


	}

	private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getParameter("userId") != null) {
			String userId = request.getParameter("userId");

			userMapper.deleteById(Integer.parseInt(userId));
			response.sendRedirect(request.getContextPath() + "/user/show");
		} else {
			String msgId = request.getParameter("msgId");

			msgMapper.deleteById(Integer.parseInt(msgId));
			response.sendRedirect(request.getContextPath() + "/shop/manageMsg");
		}


	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userId = request.getParameter("userId");

		Users user = userMapper.findById(userId);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/manage/detail.jsp");
		dispatcher.forward(request, response);


	}

	private void doReply(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String msgId = request.getParameter("msgId");

		Messages tm = msgMapper.findById(Integer.parseInt(msgId));
		request.setAttribute("msg", tm);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/manage/reply.jsp");
		dispatcher.forward(request, response);


	}

	private void doUpdateMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取请求参数
		String msgId = request.getParameter("msgId");
		String msgSender = request.getParameter("msgSender");
		String msgContent = request.getParameter("msgContent");
		String msgReplyContent = request.getParameter("msgReplyContent");

		// 创建 Users 对象
		Messages tm = new Messages();
		tm.setMsgId(Integer.parseInt(msgId));
		tm.setMsgSender(msgSender);
		tm.setMsgContent(msgContent);

		if (msgReplyContent.equals("")) {
			tm.setMsgStatus("未回复");
		} else {
			tm.setMsgStatus("已回复");
		}
		tm.setMsgReplyContent(msgReplyContent);

		// 使用 UserMapper 的 add 方法添加用户
		msgMapper.updateMsg(tm);

		// 重定向
		response.sendRedirect(request.getContextPath() + "/shop/manageMsg");
	}
}