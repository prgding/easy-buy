package me.dingshuai.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.dingshuai.dao.TmessagesDao;
import me.dingshuai.dao.TusersDao;
import me.dingshuai.dao.impl.TmessagesDaoImpl;
import me.dingshuai.dao.impl.TusersDaoImpl;

import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("userid") != null) {
			String userid = request.getParameter("userid");
			TusersDao td = new TusersDaoImpl();
			td.deleteById(Integer.parseInt(userid));
			response.sendRedirect("manage/user.jsp");
		}else {
			String msgId = request.getParameter("msgId");
			TmessagesDao td = new TmessagesDaoImpl();
			td.deleteById(Integer.parseInt(msgId));
			response.sendRedirect("manage/guestbook.jsp");
		}
	}
}
