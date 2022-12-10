package me.dingshuai.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.dingshuai.dao.TusersDao;
import me.dingshuai.dao.impl.TusersDaoImpl;
import me.dingshuai.pojo.Tusers;

import java.io.IOException;
import java.io.Serial;

@WebServlet(name = "UpdateUser", urlPatterns = "/updateUser")
public class UpdateUser extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 获取请求参数
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String location = request.getParameter("location");
		String phoneNumber = request.getParameter("phoneNumber");

		System.out.println(userid + " " + username + " " + password + " " + location + " " + phoneNumber);

		Tusers user1 = (Tusers) request.getSession().getAttribute("user");

		// 创建 Tusers 对象
		Tusers user = new Tusers();
		user.setUserId(Integer.parseInt(userid));
		user.setUsername(username);
		user.setPassword(password);
		user.setLocation(location);
		user.setPhoneNumber(phoneNumber);

		// 创建 TusersDao 对象
		TusersDao dao = new TusersDaoImpl();

		// 使用 TusersDao 的 add 方法添加用户
		dao.update(user);

		// 刷新session
		try {
			if (user1.getUsername().equals("admin")) {
				response.sendRedirect("manage/user.jsp");
			} else {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("index.jsp");
			}
		}catch (Exception e) {
			request.setAttribute("sessionMsg", "Session失效，请重新登陆");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException ex) {
				throw new RuntimeException(ex);
			}
		}

	}
}
