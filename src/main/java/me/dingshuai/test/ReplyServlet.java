package me.dingshuai.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.dingshuai.dao.TmessagesDao;
import me.dingshuai.dao.impl.TmessagesDaoImpl;
import me.dingshuai.pojo.Tmessages;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReplyServlet", urlPatterns = "/reply")
public class ReplyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String msgId = request.getParameter("msgId");

		TmessagesDao td = new TmessagesDaoImpl();
		Tmessages tm = new Tmessages();
		tm = td.findById(Integer.parseInt(msgId));

	}
}
