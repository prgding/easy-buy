<%@ page import="java.util.List" %>
<%@ page import="me.dingshuai.pojo.Tusers" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<Tusers> users = new ArrayList<>();
	Tusers u1 = new Tusers();
	Tusers u2 = new Tusers();

	u1.setUsername("ding");
	u1.setPassword("111");
	u2.setUsername("ding2");
	u2.setPassword("222");

	users.add(u1);
	users.add(u2);

	request.setAttribute("userList", users);
%>

<c:forEach items="${userList}" var="u">
	name:${u.username},password:${u.password} <br>
</c:forEach>