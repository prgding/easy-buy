<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>在线购物网 - 首页</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
		<script src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
		<style>
            p {
                text-align: center;
            }

            h2 {
                text-align: center;
            }
		</style>
	</head>
	<body>
		<div id="header" class="wrap">
			<div class="help">
				<a href="#" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a><a href="guestbook.jsp">留言</a>
			</div>
		</div>
		<div id="register" class="wrap">
			<div class="shadow">
				<em class="corner lb"></em>
				<em class="corner rt"></em>
				<div class="box">
					<h1>欢迎注册</h1>
					<ul class="steps clearfix">
						<li class="current"><em></em>填写注册信息</li>
						<li class="last"><em></em>注册成功</li>
					</ul>
					<form id="regForm" method="post" action="account/register" onsubmit="return checkForm(this);">
						<table>
							<tr>
								<td class="field">用户名：</td>
								<td><input class="text" type="text" name="userName" onfocus="FocusItem(this)"
										   onblur="CheckItem(this);checkUsernameDuplicate(this);"/><span></span>
								</td>
							</tr>
							<tr>
								<td class="field">登录密码：</td>
								<td>
									<input class="text" type="password" id="passWord" name="passWord" onfocus="FocusItem(this)" onblur="CheckItem(this)"
									/><span></span></td>
							</tr>
							<tr>
								<td class="field">确认密码：</td>
								<td><input class="text" type="password" name="rePassWord" onfocus="FocusItem(this)" onblur="CheckItem(this);"
								/><span></span></td>
							</tr>
							<tr>
								<td></td>
								<td><label class="ui-green"><input type="submit" name="submit" value="提交注册"/></label></td>
							</tr>
						</table>

						<c:if test="${not empty RegisterMsg}">
							<br>
							<p><span style="color: red;">${RegisterMsg}</span></p>
						</c:if>

					</form>
				</div>
			</div>
			<div class="clear"></div>
		</div>

	</body>
</html>
