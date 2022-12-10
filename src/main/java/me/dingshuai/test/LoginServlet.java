package me.dingshuai.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.dingshuai.dao.TusersDao;
import me.dingshuai.dao.impl.TusersDaoImpl;
import me.dingshuai.pojo.Tusers;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取表单提交的用户名和密码
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");

		// 根据用户名和密码查询用户是否存在
		TusersDao dao = new TusersDaoImpl();
		Tusers user = dao.findByUserNameAndPassWord(userName, passWord);

		if (userName.equals("admin")&&passWord.equals("admin")){
			// 用户存在，登录成功
			// 设置会话属性，标识用户已经登录
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// 跳转到用户信息页面
			response.sendRedirect("manage/index.html");
		}

		else if (user != null) {
			// 用户存在，登录成功
			// 设置会话属性，标识用户已经登录
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// 跳转到用户信息页面
			response.sendRedirect("index.jsp");
		} else {
			// 用户不存在，登录失败
			// 设置错误消息，并跳转到登录页面
			request.setAttribute("errorMessage", "用户名或密码错误，请重试");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}
}

