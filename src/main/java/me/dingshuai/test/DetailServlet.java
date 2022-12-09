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
		out.println("<!DOCTYPE html");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
		out.println("</head>");
		out.println("<body>");

		out.println("<div id='main' class='wrap'>");
		out.println("	<div class='main'>");
		out.println("		<h2>修改用户</h2>");
		out.println("		<div class='manage'>");
		out.println("			<form action='/shopping/update' method='post'>");
		out.println("				<table class='form'>");
		out.println("					<tr>");
		out.println("						<td class='field'>userId：</td>");

		String userid = request.getParameter("userid");
		TusersDao td = new TusersDaoImpl();
		Tusers user = td.findById(userid);

		out.println("						<td><input type='text' class='text' name='userid' value='"+user.getUserId()+"' readonly='readonly' " +
				"/></td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td class='field'>用户名：</td>");
		out.println("						<td><input type='text' class='text' name='username' value='"+user.getUsername()+"' /></td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td class='field'>密码：</td>");
		out.println("						<td><input type='text' class='text' name='password' value='"+user.getPassword()+"' /></td>");
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
		out.println("<script>");
		out.println("    document.querySelector('input[type=submit]').addEventListener('click', function() {");
		out.println("        alert('保存成功！');");
		out.println("    });");
		out.println("</script>");


	}
}
