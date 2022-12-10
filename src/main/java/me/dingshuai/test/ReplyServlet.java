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
		out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
		out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
		out.println("<title>后台管理 - 在线购物网</title>");
		out.println("<link type='text/css' rel='stylesheet' href='css/style.css' />");
		out.println("<script type='text/javascript' src='scripts/function-manage.js'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='header' class='wrap'>");
		out.println("	<div id='logo'><img src='images/logo.gif' /></div>");
		out.println("	<div class='help'><a href='index.jsp'>返回前台页面</a></div>");
		out.println("	<div class='navbar'>");
		out.println("		<ul class='clearfix'>");
		out.println("			<li><a href='index.html'>首页</a></li>");
		out.println("			<li><a href='user.jsp'>用户</a></li>");
		out.println("			<li><a href='product.html'>商品</a></li>");
		out.println("			<li><a href='order.html'>订单</a></li>");
		out.println("			<li class='current'><a href='guestbook.jsp'>留言</a></li>");
		out.println("			<li><a href='news.html'>新闻</a></li>");
		out.println("		</ul>");
		out.println("	</div>");
		out.println("</div>");
		out.println("<div id='childNav'>");
		out.println("	<div class='welcome wrap'>");
		out.println("		管理员admin您好，今天是2012-12-21，欢迎回到管理后台。");
		out.println("	</div>");
		out.println("</div>");
		out.println("<div id='position' class='wrap'>");
		out.println("	您现在的位置：<a href='index.html'>易买网</a> &gt; 管理后台");
		out.println("</div>");
		out.println("<div id='main' class='wrap'>");
		out.println("	<div id='menu-mng' class='lefter'>");
		out.println("		<div class='box'>");
		out.println("			<dl>");
		out.println("				<dt>用户管理</dt>");
		out.println("				<dd><em><a href='user-add.jsp'>新增</a></em><a href='user.jsp'>用户管理</a></dd>");
		out.println("				<dt>商品信息</dt>");
		out.println("				<dd><em><a href='productClass-add.html'>新增</a></em><a href='productClass.html'>分类管理</a></dd>");
		out.println("				<dd><em><a href='product-add.html'>新增</a></em><a href='product.html'>商品管理</a></dd>");
		out.println("				<dt>订单管理</dt>");
		out.println("				<dd><a href='order.html'>订单管理</a></dd>");
		out.println("				<dt>留言管理</dt>");
		out.println("				<dd><a href='guestbook.jsp'>留言管理</a></dd>");
		out.println("				<dt>新闻管理</dt>");
		out.println("				<dd><em><a href='news-add.html'>新增</a></em><a href='news.html'>新闻管理</a></dd>");
		out.println("			</dl>");
		out.println("		</div>");
		out.println("	</div>");
		out.println("	<div class='main'>");
		out.println("		<h2>回复留言</h2>");
		out.println("		<div class='manage'>");
		out.println("			<form action='/shopping/updateMsg' method='post'>");
		out.println("				<table class='form'>");

		String msgId = request.getParameter("msgId");

		TmessagesDao td = new TmessagesDaoImpl();
		Tmessages tm = td.findById(Integer.parseInt(msgId));


		out.println("					<tr>");
		out.println("						<td class='field'>留言ID：</td>");
		out.println("						<td><input type='text' class='text' name='msgId' value='" + tm.getMsgId() + "' readonly='readonly' /></td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td class='field'>留言姓名：</td>");
		out.println("						<td><input type='text' class='text' name='msgSender' value='" + tm.getMsgSender() + "' /></td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td class='field'>留言内容：</td>");
		out.println("						<td><input type='text' class='text' name='msgContent' value='" + tm.getMsgContent() + "' /></td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td class='field'>回复内容：</td>");
		out.println("						<td><textarea name='msgReplyContent'>" + tm.getMsgReplyContent() + "</textarea></td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td></td>");
		out.println("						<td><label class='ui-blue'><input type='submit' name='submit' value='更新' /></label></td>");
		out.println("					</tr>");


		out.println("				</table>");
		out.println("			</form>");
		out.println("		</div>");
		out.println("	</div>");
		out.println("	<div class='clear'></div>");
		out.println("</div>");
		out.println("<div id='footer'>");
		out.println("	Copyright &copy; 2022   All Rights Reserved. 京ICP证1000001号");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");


	}
}
