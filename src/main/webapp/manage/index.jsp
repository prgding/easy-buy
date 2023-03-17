<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<h2>管理首页</h2>
				<div id="welcome" class="manage">
					<div class="shadow">
						<em class="corner lb"></em>
						<em class="corner rt"></em>
						<div class="box">
							<div class="msg">
								<p>欢迎回来</p>
								<p>当前在线人数：${onlineUser}人
									<br>(待优化，因为关闭浏览器 session 没有自动销毁)</p>
								<p>当前已登录人数：${loggedInUser}人</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
