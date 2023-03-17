<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>
	<title>后台管理 - 在线购物网</title>
	<link type='text/css' rel='stylesheet' href='../css/style.css'/>
	<script type='text/javascript' src='../scripts/delete.js'></script>
</head>
<body>
	<%@include file="navbar.jsp" %>
	<div id='main' class='wrap'>
		<div class='main'>
			<h2>修改用户</h2>
			<div class='manage'>
				<form action='${pageContext.request.contextPath}/user/modifyUserInfo' method='post'>
					<table class='form'>
						<tr>
							<td class='field'>userId：</td>
							<td><input type='text' class='text' name='userId' value='${user.userId}' readonly='readonly'/></td>

						</tr>
						<tr>
							<td class='field'>用户名：</td>
							<td><input type='text' class='text' name='userName' value='${user.userName}'/></td>
						</tr>
						<tr>
							<td class='field'>密码：</td>
							<td><input type='text' class='text' name='passWord' value='${user.passWord}'/></td>
						</tr>
						<tr>
							<td class='field'>送货地址：</td>
							<td><input type='text' class='text' name='location' value='${user.location}'/></td>
						</tr>
						<tr>
							<td class='field'>手机号码：</td>
							<td><input type='text' class='text' name='phoneNumber' value='${user.phoneNumber}'/></td>
						</tr>
						<tr>
							<td></td>
							<td><label class='ui-blue'><input type='submit' name='submit' value='更新'/></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>