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
import java.io.PrintWriter;

@WebServlet(name = "DetailServlet", urlPatterns = "/detail")
public class DetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
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
		out.println("			<li class='current'><a href='user.jsp'>用户</a></li>");
		out.println("			<li><a href='product.html'>商品</a></li>");
		out.println("			<li><a href='order.html'>订单</a></li>");
		out.println("			<li><a href='guestbook.jsp'>留言</a></li>");
		out.println("			<li><a href='news.html'>新闻</a></li>");
		out.println("		</ul>");
		out.println("	</div>");
		out.println("</div>");
		out.println("<div id='childNav'>");
		out.println("	<div class='welcome wrap'>");
		out.println("		管理员admin您好，今天是2022-12-07，欢迎回到管理后台。");
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
		out.println("		<h2>修改用户</h2>");
		out.println("		<div class='manage'>");
		out.println("			<form action='/shopping/updateUser' method='post'>");
		out.println("				<table class='form'>");


		String userId = request.getParameter("userId");
		TusersDao td = new TusersDaoImpl();
		Tusers user = td.findById(userId);

		out.println("					<tr>");
		out.println("						<td class='field'>userId：</td>");
		out.println("						<td><input type='text' class='text' name='userId' value='"+user.getUserId()+"' readonly='readonly' " +
				"/></td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td class='field'>用户名：</td>");
		out.println("						<td><input type='text' class='text' name='userName' value='"+user.getUsername()+"' /></td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td class='field'>密码：</td>");
		out.println("						<td><input type='text' class='text' name='passWord' value='"+user.getPassword()+"' /></td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td class='field'>送货地址：</td>");
		out.println("						<td><input type='text' class='text' name='location' value='"+user.getLocation()+"' /></td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td class='field'>手机号码：</td>");
		out.println("						<td><input type='text' class='text' name='phoneNumber' value='"+user.getPhoneNumber()+"' /></td>");


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
		out.println("</body>");
		out.println("</html>");
	}
}
