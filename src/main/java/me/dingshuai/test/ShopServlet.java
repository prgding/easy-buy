package me.dingshuai.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.dingshuai.dao.TmessagesDao;
import me.dingshuai.dao.TusersDao;
import me.dingshuai.dao.impl.TmessagesDaoImpl;
import me.dingshuai.dao.impl.TusersDaoImpl;
import me.dingshuai.pojo.Tmessages;
import me.dingshuai.pojo.Tusers;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopServlet", urlPatterns = {"/addMsg", "/showMsg", "/manageMsg", "/delete", "/detail", "/reply", "/updateMsg"})
public class ShopServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String servletPath = request.getServletPath();
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			switch (servletPath) {
				case "/addMsg" -> doAddMsg(request, response);
				case "/showMsg" -> doShowMsg(request, response);
				case "/manageMsg" -> doManageMsg(request, response);
				case "/delete" -> doDel(request, response);
				case "/detail" -> doDetail(request, response);
				case "/reply" -> doReply(request, response);
				case "/updateMsg" -> doUpdateMsg(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "未登陆或session失效，请重新登陆");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void doAddMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String guestName = request.getParameter("guestName");
		String guestTitle = request.getParameter("guestTitle");
		String guestContent = request.getParameter("guestContent");

		TmessagesDao td = new TmessagesDaoImpl();
		Tmessages tm = new Tmessages();
		tm.setMsgSender(guestName);
		tm.setMsgTitle(guestTitle);
		tm.setMsgContent(guestContent);
		td.addMsg(tm);

		response.sendRedirect("guestbook.jsp");
	}

	private void doShowMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TmessagesDao td = new TmessagesDaoImpl();
		List<Tmessages> tmessages = td.findAll();
		HttpSession session = request.getSession(false);
		session.setAttribute("tmessages", tmessages);
		response.sendRedirect("guestbook.jsp");
	}

	private void doManageMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TmessagesDao td = new TmessagesDaoImpl();
		List<Tmessages> tmessages = td.findAll();
		HttpSession session = request.getSession(false);
		session.setAttribute("tmessages", tmessages);
		response.sendRedirect("manage/guestbook.jsp");
	}

	private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getParameter("userId") != null) {
			String userId = request.getParameter("userId");
			TusersDao td = new TusersDaoImpl();
			td.deleteById(Integer.parseInt(userId));
			response.sendRedirect(request.getContextPath() + "/showUsers");
		} else {
			String msgId = request.getParameter("msgId");
			TmessagesDao td = new TmessagesDaoImpl();
			td.deleteById(Integer.parseInt(msgId));
			response.sendRedirect(request.getContextPath() + "/showMsg");
		}
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userId = request.getParameter("userId");
		TusersDao td = new TusersDaoImpl();
		Tusers user = td.findById(userId);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("manage/detail.jsp");
		dispatcher.forward(request, response);
	}

	private void doReply(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String msgId = request.getParameter("msgId");
		TmessagesDao td = new TmessagesDaoImpl();
		Tmessages tm = td.findById(Integer.parseInt(msgId));
		request.setAttribute("msg", tm);
		RequestDispatcher dispatcher = request.getRequestDispatcher("manage/reply.jsp");
		dispatcher.forward(request, response);
	}

	private void doUpdateMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取请求参数
		String msgId = request.getParameter("msgId");
		String msgSender = request.getParameter("msgSender");
		String msgContent = request.getParameter("msgContent");
		String msgReplyContent = request.getParameter("msgReplyContent");

		// 创建 Tusers 对象
		Tmessages tm = new Tmessages();
		tm.setMsgId(Integer.parseInt(msgId));
		tm.setMsgSender(msgSender);
		tm.setMsgContent(msgContent);

		if (msgReplyContent.equals("")) {
			tm.setMsgStatus("未回复");
		} else {
			tm.setMsgStatus("已回复");
		}
		tm.setMsgReplyContent(msgReplyContent);

		// 创建 TusersDao 对象
		TmessagesDao dao = new TmessagesDaoImpl();

		// 使用 TusersDao 的 add 方法添加用户
		dao.updateMsg(tm);

		// 重定向
		response.sendRedirect(request.getContextPath()+"/manageMsg");
	}

}