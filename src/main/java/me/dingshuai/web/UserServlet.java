package me.dingshuai.web;

import jakarta.servlet.http.*;
import me.dingshuai.pojo.User;
import me.dingshuai.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserServlet extends HttpServlet {
	private final UserService userService;

	public UserServlet(UserService userService) {
		this.userService = userService;
	}

	// 本层方法
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

	// 增
	@RequestMapping("/register")
	public String register(@ModelAttribute("user") User user) {
		System.out.println("user = " + user);
		return userService.Register(user) == 1 ? "redirect:/index.jsp" : "redirect:/error.html";
	}

	// 删
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam String userId, HttpSession session) {
		User CurrentUser = (User) session.getAttribute("user");
		if (userService.deleteUser(Integer.parseInt(userId)) == 1) {
			if (CurrentUser.getUserName().equals("admin")) {
				return "redirect:/user/showUsersForAdmin";
			}
			return "redirect:/user/exit";
		}
		return "redirect:/error.html";
	}

	// 改
	@RequestMapping("/modifyUserInfo")
	private String modifyUserInfo(@ModelAttribute("user") User user, HttpSession session) {
		int status = userService.modifyUserInfo(user);
		User currentUser = (User) session.getAttribute("user");
		if (status == 1) {
			// 跳转成功页面
			if (currentUser.getUserName().equals("admin")) {
				// 管理他人信息（不需要刷新 session，因为showUsersForAdmin重新走数据库了）
				return "redirect:/user/showUsersForAdmin";
			} else {
				// 普通用户
				System.out.println("普通用户");
				session.setAttribute("user", user);
				return "redirect:/index.jsp";
			}
		} else {
			// 跳转到错误页面
			return "redirect:/error.html";
		}
	}

	// 查一个
	@RequestMapping("/login")
	public String login(@RequestParam String userName, @RequestParam String passWord, HttpServletRequest request, Model model) {
		User user = userService.login(userName, passWord);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if (user.getUserName().equals("admin")) {
				return "redirect:/manage/index.jsp";
			} else {
				return "redirect:/index.jsp";
			}
		} else {
			model.addAttribute("errorMessage", "用户名或密码错误");
			return "/login.jsp";
		}
	}

	@RequestMapping("/checkIfExists")
	public void checkIfExists(@RequestParam String userName, HttpServletResponse response) throws IOException {
		User user = userService.checkIfExists(userName);
		PrintWriter out = response.getWriter();
		if (user != null) {
			out.print("用户名已存在");
		} else {
			out.print("用户名可用");
		}
	}

	@RequestMapping("/showOneUserForManage")
	public String showOneUserForManage(@RequestParam String userId, Model model) {
		System.out.println("方法执行了");
		User user = userService.showOneUser(Integer.parseInt(userId));
		model.addAttribute("user", user);
		return "/manage/user-modify.jsp";
	}

	// 查所有
	@RequestMapping("/showUsersForAdmin")
	public String showUsersForAdmin(Model model) {
		List<User> users = userService.showUsersForAdmin();
		model.addAttribute("user", users);
		return "/manage/user.jsp";
	}
}
