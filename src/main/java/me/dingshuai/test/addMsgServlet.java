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

@WebServlet(name = "addMsgServlet", value = "/addmsg")
public class addMsgServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String guestName = request.getParameter("guestName");
		String guestTitle = request.getParameter("guestTitle");
		String guestContent = request.getParameter("guestContent");

		TmessagesDao td = new TmessagesDaoImpl();
		Tmessages tm = new Tmessages();
		tm.setMsgSender(guestName);
		tm.setMsgTitle(guestTitle);
		tm.setMsgContent(guestContent);
		td.addMsg(tm);

		response.sendRedirect("guestbook.jsp");
	}
}
