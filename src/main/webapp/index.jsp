<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>在线购物网 - 首页</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/delete.js"></script>
	</head>
	<body>
		<div id="header" class="wrap">
			<div class="help">
				<c:if test="${not empty user}">
					欢迎您，${user.userName}
					<c:if test="${user.userName != 'admin'}">
						<a href='user-modify.jsp'>修改个人信息</a>
						<a href='${pageContext.request.contextPath}/user/exit'>登出</a>
						<a href="javascript:DeleteUser(${user.userId});">注销账户</a>
					</c:if>
					<c:if test="${user.userName == 'admin'}">
						<a href='manage/index.jsp'>进入管理后台</a>
						<a href='${pageContext.request.contextPath}/user/exit'>登出</a>
					</c:if>
				</c:if>

				<c:if test="${empty user}">
					<a href='login.jsp'>登录</a>
					<a href='register.jsp'>注册</a>
				</c:if>

				<a href="${pageContext.request.contextPath}/msg/showAllMsgsForUser">留言</a></div>
		</div>
		<h2>这里是用户首页</h2>
	</body>
</html>
