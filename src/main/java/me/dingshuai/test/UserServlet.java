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

@WebServlet(name = "UserServlet", urlPatterns = {"/user/update", "/user/show"})
public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		switch (servletPath) {
			case "/user/update" -> doUpdateUser(request, response);
			case "/user/show" -> doShowUsers(request, response);
		}
	}


	private void doUpdateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取请求参数
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String location = request.getParameter("location");
		String phoneNumber = request.getParameter("phoneNumber");

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

		// 根据情况跳转到不同的页面
		try {
			// 获取当前用户
			HttpSession session = request.getSession();
			Tusers user1 = (Tusers) session.getAttribute("user");

			// 是否是管理员
			if (user1.getUsername().equals("admin")) {
				// 是更改个人信息还是管理他人信息
				String page = request.getParameter("page");
				if ("user-modify".equals(page)) {
					// 更改个人信息（需要刷新 session）
					session.setAttribute("user", user);
					response.sendRedirect(request.getContextPath() + "/index.jsp");
				} else {
					// 管理他人信息（不需要刷新 session，因为重新走数据库了）
					response.sendRedirect(request.getContextPath() + "/user/show");
				}
			} else {
				// 普通用户，
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
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
		response.sendRedirect(request.getContextPath() + "/manage/user.jsp");
	}
}
