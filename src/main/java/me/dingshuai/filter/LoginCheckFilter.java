package me.dingshuai.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.dingshuai.dao.UsersDao;
import me.dingshuai.dao.impl.UsersDaoImpl;
import me.dingshuai.pojo.Users;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LoginCheckFilter implements Filter {
	private UsersDao userDao = new UsersDaoImpl();

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		HttpSession session = request.getSession();
		String servletPath = request.getServletPath();
//		System.out.print(servletPath + " ");

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
			Users user = userDao.findByUserNameAndPassWord(username, password);
			if (user != null) {
				session.setAttribute("user", user);
				session.setAttribute("date", format);
			}
		}

		if (session != null && session.getAttribute("user") != null) {
			// 放行
//			System.out.println("放行");
			filterChain.doFilter(request, response);
		} else {
			// 拦截
			System.out.println("拦截");
			request.setAttribute("errorMessage", "未登陆或session失效，请重新登陆");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}
}
