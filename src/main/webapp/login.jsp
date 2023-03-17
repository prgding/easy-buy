<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>在线购物网 - 首页</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
		<style>

		</style>
	</head>
	<body>
		<div id="header" class="wrap">
			<div class="help">
				<a href="#" class="shopping">购物车</a>
				<a href="login.jsp">登录</a>
				<a href="register.jsp">注册</a>
				<a href="guestbook.jsp">留言</a>
			</div>
		</div>

		<div id="register" class="wrap">
			<div class="shadow">
				<em class="corner lb"></em>
				<em class="corner rt"></em>
				<div class="box">
					<h1>欢迎</h1>
					<form id="loginForm" method="post" action="${pageContext.request.contextPath}/user/login" onsubmit="return checkForm(this)">
						<table>
							<tr>
								<td class="field">用户名：</td>
								<td><input class="text" type="text" name="userName" onfocus="FocusItem(this)" onblur="CheckItem(this);"/><span></span>
								</td>
							</tr>

							<tr>
								<td class="field">登录密码：</td>
								<td><input class="text" type="password" id="passWord" name="passWord" onfocus="FocusItem(this)"
										   onblur="CheckItem(this);"/><span></span></td>
							</tr>

							<tr>
								<td></td>
								<td>
									<input type="checkbox" name="tenDaysLogin" value="10"/>10天免登陆
								</td>
							</tr>

							<tr>
								<td></td>
								<td>
									<label class="ui-green"><input type="submit" name="submit" value="立即登录"/></label>
								</td>
							</tr>
						</table>

						<c:if test="${errorMessage != null}">
							<br>
							<p><span style="color: red;">${errorMessage}</span></p>
						</c:if>

					</form>
					<h2>测试账户：</h2><br>
					<p>普通（跳转至商品首页）：用户名：1 密码：1</p>
					<p>管理员（跳转至后台管理）：用户名：admin 密码：admin</p>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</body>
</html>
