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
		<div id="header" class="wrap">
			<%--<div id="logo"><img src="../images/logo.gif"/></div>--%>
			<div class="help"><a href="../index.jsp">返回前台页面</a></div>
			<div class="navbar">
				<ul class="clearfix">
					<li class="current"><a href="index.jsp">首页</a></li>
					<li><a href="${pageContext.request.contextPath}/user/show">用户</a></li>
					<li><a href="product.html">商品</a></li>
					<li><a href="order.html">订单</a></li>
					<li><a href="${pageContext.request.contextPath}/shop/manageMsg">留言</a></li>
					<li><a href="news.html">新闻</a></li>
				</ul>
			</div>
		</div>
		<div id="childNav">
			<div class='welcome wrap'>
				管理员admin您好，今天是${date}，欢迎回到管理后台。<br>
			</div>
		</div>
		<div id="position" class="wrap">
			您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
		</div>
		<div id="main" class="wrap">
			<div id="menu-mng" class="lefter">
				<div class="box">
					<dl>
						<dt>用户管理</dt>
						<dd><em><a href="user-add.jsp">新增</a></em><a href="user.jsp">用户管理</a></dd>
						<dt>商品信息</dt>
						<dd><em><a href="productClass-add.html">新增</a></em><a href="productClass.html">分类管理</a></dd>
						<dd><em><a href="product-add.html">新增</a></em><a href="product.html">商品管理</a></dd>
						<dt>订单管理</dt>
						<dd><a href="order.html">订单管理</a></dd>
						<dt>留言管理</dt>
						<dd><a href="guestbook.jsp">留言管理</a></dd>
						<dt>新闻管理</dt>
						<dd><em><a href="news-add.html">新增</a></em><a href="news.html">新闻管理</a></dd>
					</dl>
				</div>
			</div>
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
			<div class="clear"></div>
		</div>
		<div id="footer">
			Copyright &copy; 2022 All Rights Reserved. 京ICP证1000001号
		</div>
	</body>
</html>
