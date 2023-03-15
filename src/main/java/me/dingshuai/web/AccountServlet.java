package me.dingshuai.web;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.dingshuai.pojo.User;
import me.dingshuai.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/account")
public class AccountServlet {

	private final AccountService accountService;

	public AccountServlet(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping("/login")
	public String login(@RequestParam String userName, @RequestParam String passWord, HttpServletRequest request) {
		User user = accountService.Login(userName, passWord);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			userName = user.getUserName();
			System.out.println("userName = " + userName);
			if (userName.equals("admin")) {
				return "redirect:/manage/index.jsp";
			}
		}
		request.setAttribute("errorMessage", "用户名或密码错误");
		return "forward:/index.jsp";
	}

	@RequestMapping("/register")
	public String register(@RequestParam String userName, @RequestParam String passWord) {
		accountService.Register(userName, passWord);
		return "redirect:/index.jsp";
	}

	@RequestMapping("/checkIfExists")
	public void checkUsernameDuplicate(@RequestParam String userName, HttpServletResponse response) throws IOException {
		System.out.println("userName = " + userName);
		int i = accountService.CheckIfExists(userName);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (i == 1) {
			out.print("用户名已存在");
		} else {
			out.print("用户名可用");
		}
	}

	private void invalidateCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
		}
	}

	@RequestMapping("/exit")
	public String exit(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		invalidateCookies(request, response);
		return "redirect:/index.jsp";
	}
}
