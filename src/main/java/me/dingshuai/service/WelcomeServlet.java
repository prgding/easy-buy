package me.dingshuai.service;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import me.dingshuai.dao.UsersDao;
import me.dingshuai.dao.impl.UsersDaoImpl;
import me.dingshuai.pojo.Users;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcome"})
public class WelcomeServlet extends HttpServlet {
	private UsersDao usersDao = new UsersDaoImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String format = formatter.format(now);

		Cookie[] cookies = request.getCookies();
		String username = null;
		String password = null;

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if (name.equals("username")) {
					username = cookie.getValue();
				} else if (name.equals("password")) {
					password = cookie.getValue();
				}
			}
		}

		if (username != null && password != null) {
			Users user = usersDao.findByUserNameAndPassWord(username, password);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("date", format);

				if (user.getUsername().equals("admin")) {
					// 跳转到用户信息页面
					response.sendRedirect(request.getContextPath() + "/manage/index.jsp");
				} else {
					// 跳转到用户信息页面
					response.sendRedirect(request.getContextPath() + "index.jsp");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
}
