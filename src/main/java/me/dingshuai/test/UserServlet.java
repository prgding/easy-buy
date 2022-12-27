package me.dingshuai.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.dingshuai.dao.TusersDao;
import me.dingshuai.dao.impl.TusersDaoImpl;
import me.dingshuai.pojo.Tusers;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/updateUser", "/showUsers"})
public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			switch (servletPath) {
				case "/updateUser" -> doUpdateUser(request, response);
				case "/showUsers" -> doShowUsers(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "未登陆或session失效，请重新登陆");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}


	private void doUpdateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
				response.sendRedirect(request.getContextPath() + "/showUsers");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			request.setAttribute("errorMessage", "session失效，请重新登陆");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	private void doShowUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TusersDao td = new TusersDaoImpl();
		List<Tusers> users = td.findAll();
		HttpSession session = request.getSession(false);
		session.setAttribute("users", users);
		response.sendRedirect("manage/user.jsp");
	}
}
