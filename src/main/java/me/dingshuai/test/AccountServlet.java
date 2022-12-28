package me.dingshuai.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import me.dingshuai.dao.TusersDao;
import me.dingshuai.dao.impl.TusersDaoImpl;
import me.dingshuai.pojo.Tusers;

import java.io.IOException;

@WebServlet(name = "AccountServlet", urlPatterns = {"/login", "/register", "/exit"})
public class AccountServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		switch (servletPath) {
			case "/login" -> doLogin(request, response);
			case "/register" -> doRegister(request, response);
			case "/exit" -> doExit(request, response);
		}
	}


	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取表单提交的用户名和密码
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");

		// 根据用户名和密码查询用户是否存在
		TusersDao dao = new TusersDaoImpl();
		Tusers user = dao.findByUserNameAndPassWord(userName, passWord);
		if (user == null) {
			// 用户不存在，登录失败
			// 设置错误消息，并跳转到登录页面
			request.setAttribute("errorMessage", "用户名或密码错误，请重试");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);

		} else if (user != null) {
			// 用户存在，登录成功
			// 设置会话属性，标识用户已经登录
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			String tenDaysLogin = request.getParameter("tenDaysLogin");
			if (tenDaysLogin.equals("10")) {
				Cookie cookie1 = new Cookie("username", userName);
				Cookie cookie2 = new Cookie("password", passWord);

				cookie1.setMaxAge(60 * 60 * 24 * 10);
				cookie2.setMaxAge(60 * 60 * 24 * 10);

				cookie1.setPath(request.getContextPath());
				cookie2.setPath(request.getContextPath());

				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}

			if (user.getUsername().equals("admin")) {
				// 跳转到用户信息页面
				response.sendRedirect("manage/index.jsp");
			} else {
				// 跳转到用户信息页面
				response.sendRedirect("index.jsp");
			}
		}
	}

	private void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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

	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 销毁会话
		HttpSession session = request.getSession(false);
		session.invalidate();

		// 重定向到首页
		response.sendRedirect("index.jsp");
	}
}
