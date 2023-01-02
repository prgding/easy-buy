<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>
	<title>后台管理 - 在线购物网</title>
	<link type='text/css' rel='stylesheet' href='../css/style.css'/>
	<script type='text/javascript' src='../scripts/function-manage.js'></script>
</head>
<body>
	<div id='header' class='wrap'>
		<div id='logo'><img src='../images/logo.gif'/></div>
		<div class='help'><a href='../index.jsp'>返回前台页面</a></div>
		<div class='navbar'>
			<ul class='clearfix'>
				<li><a href='index.jsp'>首页</a></li>
				<li class='current'><a href='${pageContext.request.contextPath}/user/show'>用户</a></li>
				<li><a href='product.html'>商品</a></li>
				<li><a href='order.html'>订单</a></li>
				<li><a href='${pageContext.request.contextPath}/shop/manageMsg'>留言</a></li>
				<li><a href='news.html'>新闻</a></li>
			</ul>
		</div>
	</div>
	<div id='childNav'>
		<div class='welcome wrap'>
			管理员admin您好，今天是${date}，欢迎回到管理后台。
		</div>
	</div>
	<div id='position' class='wrap'>
		您现在的位置：<a href='index.jsp'>易买网</a> &gt; 管理后台
	</div>
	<div id='main' class='wrap'>
		<div id='menu-mng' class='lefter'>
			<div class='box'>
				<dl>
					<dt>用户管理</dt>
					<dd><em><a href='user-add.jsp'>新增</a></em><a href='user.jsp'>用户管理</a></dd>
					<dt>商品信息</dt>
					<dd><em><a href='productClass-add.html'>新增</a></em><a href='productClass.html'>分类管理</a></dd>
					<dd><em><a href='product-add.html'>新增</a></em><a href='product.html'>商品管理</a></dd>
					<dt>订单管理</dt>
					<dd><a href='order.html'>订单管理</a></dd>
					<dt>留言管理</dt>
					<dd><a href='guestbook.jsp'>留言管理</a></dd>
					<dt>新闻管理</dt>
					<dd><em><a href='news-add.html'>新增</a></em><a href='news.html'>新闻管理</a></dd>
				</dl>
			</div>
		</div>
		<div class='main'>
			<h2>修改用户</h2>
			<div class='manage'>
				<form action='${pageContext.request.contextPath}/user/update' method='post'>
					<table class='form'>

						<tr>
							<td class='field'>userId：</td>
							<td><input type='text' class='text' name='userId' value='${user.userId}' readonly='readonly'/></td>

						</tr>
						<tr>
							<td class='field'>用户名：</td>
							<td><input type='text' class='text' name='userName' value='${user.username}'/></td>
						</tr>
						<tr>
							<td class='field'>密码：</td>
							<td><input type='text' class='text' name='passWord' value='${user.password}'/></td>
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
		<div class='clear'></div>
	</div>
</body>
</html>