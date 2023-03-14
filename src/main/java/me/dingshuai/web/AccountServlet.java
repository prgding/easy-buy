package me.dingshuai.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.dingshuai.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/account")
public class AccountServlet {

	@Autowired
	private AccountService accountService;

	@RequestMapping("/login")
	public String login(@RequestParam String userName, @RequestParam String passWord) {
		accountService.Login(userName, passWord);
		return "redirect:/index.jsp";
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
	@RequestMapping("/exit")
	public String exit(@RequestParam String userName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		accountService.Exit(userName, request, response);
		return "redirect:/index.jsp";
	}
}
