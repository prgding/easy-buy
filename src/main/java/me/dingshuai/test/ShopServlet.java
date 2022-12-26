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
import java.io.PrintWriter;

@WebServlet(name = "ShopServlet", urlPatterns = {"/login", "/register", "/addMsg", "/delete", "/detail", "/reply", "/updateMsg", "/updateUser"})
public class ShopServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String servletPath = request.getServletPath();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		switch (servletPath) {
			case "/login" -> {
				// 获取表单提交的用户名和密码
				String userName = request.getParameter("userName");
				String passWord = request.getParameter("passWord");

				// 根据用户名和密码查询用户是否存在
				TusersDao dao = new TusersDaoImpl();
				Tusers user = dao.findByUserNameAndPassWord(userName, passWord);
				if (userName.equals("admin") && passWord.equals("admin")) {
					// 用户存在，登录成功
					// 设置会话属性，标识用户已经登录
					HttpSession session = request.getSession();
					session.setAttribute("user", user);

					// 跳转到用户信息页面
					response.sendRedirect("manage/index.html");
				} else if (user != null) {
					// 用户存在，登录成功
					// 设置会话属性，标识用户已经登录
					HttpSession session = request.getSession();
					session.setAttribute("user", user);

					// 跳转到用户信息页面
					response.sendRedirect("index.jsp");
				} else {
					// 用户不存在，登录失败
					// 设置错误消息，并跳转到登录页面
					request.setAttribute("errorMessage", "用户名或密码错误，请重试");
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				}
			}
			case "/register" -> {
				// 获取请求参数
				String userName = request.getParameter("userName");
				String passWord = request.getParameter("passWord");

				// 创建 Tusers 对象
				Tusers user = new Tusers(userName, passWord);

				// 创建 TusersDao 对象
				TusersDao dao = new TusersDaoImpl();
				Tusers alreadyHave = dao.checkIfExists(userName);
				if (alreadyHave != null) {
					// 用户名已存在
					request.setAttribute("RegisterMsg", "用户名已存在");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				} else {
					// 使用 TusersDao 的 add 方法添加用户
					dao.addUser(user);

					// 重定向到 userinfo.jsp 页面
					response.sendRedirect("index.jsp");
				}
			}
			case "/addMsg" -> {
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
			case "/delete" -> {
				if (request.getParameter("userId") != null) {
					String userId = request.getParameter("userId");
					TusersDao td = new TusersDaoImpl();
					td.deleteById(Integer.parseInt(userId));
					response.sendRedirect("manage/user.jsp");
				}else {
					String msgId = request.getParameter("msgId");
					TmessagesDao td = new TmessagesDaoImpl();
					td.deleteById(Integer.parseInt(msgId));
					response.sendRedirect("manage/guestbook.jsp");
				}
			}
			case "/detail" -> {
				String userId = request.getParameter("userId");
				out.println(userId);
				TusersDao td = new TusersDaoImpl();
				Tusers user = td.findById(userId);
				request.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("manage/detail.jsp");
				dispatcher.forward(request, response);
			}
			case "/reply" -> {
				String msgId = request.getParameter("msgId");
				TmessagesDao td = new TmessagesDaoImpl();
				Tmessages tm = td.findById(Integer.parseInt(msgId));
				request.setAttribute("msg", tm);
				RequestDispatcher dispatcher = request.getRequestDispatcher("manage/reply.jsp");
				dispatcher.forward(request, response);
			}
			case "/updateMsg" -> {
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
				response.sendRedirect("manage/guestbook.jsp");
			}
			case "/updateUser" -> {
				// 获取请求参数
				String userId = request.getParameter("userId");
				String userName = request.getParameter("userName");
				String passWord = request.getParameter("passWord");
				String location = request.getParameter("location");
				String phoneNumber = request.getParameter("phoneNumber");

				System.out.println(userId + " " + userName + " " + passWord + " " + location + " " + phoneNumber);

				Tusers user1 = (Tusers) request.getSession().getAttribute("user");

				// 创建 Tusers 对象
				Tusers user = new Tusers();
				user.setUserId(Integer.parseInt(userId));
				user.setUsername(userName);
				user.setPassword(passWord);
				user.setLocation(location);
				user.setPhoneNumber(phoneNumber);

				// 创建 TusersDao 对象
				TusersDao dao = new TusersDaoImpl();

				// 使用 TusersDao 的 add 方法添加用户
				dao.update(user);

				// 刷新session
				try {
					if (user1.getUsername().equals("admin")) {
						response.sendRedirect("manage/user.jsp");
					} else {
						request.getSession().setAttribute("user", user);
						response.sendRedirect("index.jsp");
					}
				}catch (Exception e) {
					request.setAttribute("sessionMsg", "Session失效，请重新登陆");
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					try {
						dispatcher.forward(request, response);
					} catch (ServletException ex) {
						throw new RuntimeException(ex);
					}
				}
			}
		}
	}
}