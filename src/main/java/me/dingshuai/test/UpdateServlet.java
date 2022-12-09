package me.dingshuai.test;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.dingshuai.dao.TusersDao;
import me.dingshuai.dao.impl.TusersDaoImpl;
import me.dingshuai.pojo.Tusers;

import java.io.IOException;
import java.io.Serial;

@WebServlet(name = "UpdateServlet", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
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
		request.getSession().setAttribute("user", user);

		// 重定向到 userinfo.jsp 页面
		response.sendRedirect("index.jsp");
	}
}
