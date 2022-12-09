package me.dingshuai.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.dingshuai.dao.TusersDao;
import me.dingshuai.dao.impl.TusersDaoImpl;
import me.dingshuai.pojo.Tusers;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 创建 Tusers 对象
		Tusers user = new Tusers(username, password);

		// 创建 TusersDao 对象
		TusersDao dao = new TusersDaoImpl();
		Tusers alreadyHave = dao.findByUsername(username);
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
}
