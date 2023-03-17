<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>后台管理 - 在线购物网</title>
		<link type="text/css" rel="stylesheet" href="../css/style.css"/>
		<script type="text/javascript" src="../scripts/delete.js"></script>
	</head>
	<body>
		<%@include file="navbar.jsp" %>

		<div id="main" class="wrap">
			<div class="main">
				<h2>用户管理</h2>
				<div class="manage">
					<table class="list">
						<tr>
							<th>userId(主键自增)</th>
							<th>用户名</th>
							<th>密码</th>
							<th>送货地址</th>
							<th>手机号</th>
							<th>操作</th>
						</tr>

						<c:forEach items="${user}" var="user">
							<tr>
								<td class='first w4 c'>${user.userId}</td>
								<td class='w1 c'>${user.userName}</td>
								<td class='w2 c'>${user.passWord}</td>
								<td class='w3 c'>${user.location}</td>
								<td class='w4 c'>${user.phoneNumber}</td>
								<td class='w1 c'>
									<a href="${pageContext.request.contextPath}/user/showOneUserForManage?userId=${user.userId}">修改</a>
									<a href="javascript:DeleteUser(${user.userId});">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>