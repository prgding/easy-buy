package me.dingshuai.web;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import me.dingshuai.mapper.UserMapper;
import me.dingshuai.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserServlet extends HttpServlet {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/update")
	private String doUpdateUser(@ModelAttribute("user") User user,
								@RequestParam(value = "page", defaultValue = "") String page,
								HttpSession session) {

		// 使用 UserMapper 的 add 方法添加用户
		userMapper.update(user);

		// 根据情况跳转到不同的页面
		// 获取当前用户
		User user1 = (User) session.getAttribute("user");

		// 是否是管理员
		if (user1.getUserName().equals("admin")) {
			// 是更改个人信息还是管理他人信息
			if ("user-modify".equals(page)) {
				// 更改个人信息（需要刷新 session）
				session.setAttribute("user", user);
				return "redirect:/index.jsp";
			} else {
				// 管理他人信息（不需要刷新 session，因为重新走数据库了）
				return "redirect:/user/show";
			}
		} else {
			// 普通用户，
			session.setAttribute("user", user);
			return "redirect:/index.jsp";
		}
	}

	@RequestMapping("/show")
	public String showUsers(Model model) {
		List<User> users = userMapper.findAll();
		model.addAttribute("user", users);
		return "/manage/user.jsp";
	}
}
