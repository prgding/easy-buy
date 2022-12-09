<%--
  Created by IntelliJ IDEA.
  User: dingshuai
  Date: 2022/12/9
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销登陆</title>
</head>
<body>
<% session.invalidate(); %>
<jsp:forward page="index.jsp"></jsp:forward>
</body>
</html>

<script>
    alert("注销成功");
</script>