package me.dingshuai.web;

import jakarta.servlet.http.*;
import me.dingshuai.mapper.UserMapper;
import me.dingshuai.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class WelcomeServlet extends HttpServlet {
	private final UserMapper userMapper;

	public WelcomeServlet(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@RequestMapping("/welcome")
	protected String welcome(HttpServletRequest request) {

		// 获取当前时间
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String format = formatter.format(now);

		// 取出 cookie
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

		// 判断 cookie 中是否有用户名和密码
		if (username != null && password != null) {
			// 记住了密码
			User user = userMapper.checkPwd(username, password);
			if (user != null) {
				// 密码正确，有用户
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("date", format);
				if (user.getUserName().equals("admin")) {
					// 管理员登录
					return "/manage/index.jsp";
				}
			}
		}

		// 没有记住密码, 普通用户登录
		return "index.jsp";
	}
}
