package me.dingshuai.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class OnlineUserListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session created id: " + se.getSession());
		ServletContext application = se.getSession().getServletContext();
		Integer onlineUser = (Integer) application.getAttribute("onlineUser");
		if (onlineUser == null) {
			application.setAttribute("onlineUser", 0);
		} else {
			application.setAttribute("onlineUser", onlineUser + 1);
		}
		System.out.println(onlineUser);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session destroyed id: " + se.getSession());
		ServletContext application = se.getSession().getServletContext();
		Integer onlineUser = (Integer) application.getAttribute("onlineUser");
		application.setAttribute("onlineUser", onlineUser - 1);
		System.out.println(onlineUser);
	}
}