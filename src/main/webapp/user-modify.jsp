<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="me.dingshuai.pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>后台管理 - 在线购物网</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/main/webapp/scripts/delete.js"></script>
	</head>
	<body>
		<div id="header" class="wrap">
			<%--<div id="logo"><img src="${pageContext.request.contextPath}/images/logo.gif"/></div>--%>
			<div class="help"><a href="index.jsp">返回前台页面</a></div>
			<div class="navbar">
				<ul class="clearfix">
					<li class="current"><a href="#">首页</a></li>
					<li><a href="#">图书</a></li>
					<li><a href="#">百货</a></li>
					<li><a href="#">品牌</a></li>
					<li><a href="#">促销</a></li>
				</ul>
			</div>
		</div>
		<div id="childNav">
			<div class="wrap">
				<ul class="clearfix">
					<li class="first"><a href="#">音乐</a></li>
					<li><a href="#">影视</a></li>
					<li><a href="#">少儿</a></li>
					<li><a href="#">动漫</a></li>
					<li><a href="#">小说</a></li>
					<li><a href="#">外语</a></li>
					<li><a href="#">数码相机</a></li>
					<li><a href="#">笔记本</a></li>
					<li><a href="#">羽绒服</a></li>
					<li><a href="#">秋冬靴</a></li>
					<li><a href="#">运动鞋</a></li>
					<li><a href="#">美容护肤</a></li>
					<li><a href="#">家纺用品</a></li>
					<li><a href="#">婴幼奶粉</a></li>
					<li><a href="#">饰品</a></li>
					<li class="last"><a href="#">Investor Relations</a></li>
				</ul>
			</div>
		</div>
		<div id="position" class="wrap">
			您现在的位置：<a href="index.jsp">易买网</a> &gt; 个人信息修改
		</div>
		<div id="main" class="wrap">
			<div class="lefter">
				<div class="box">
					<h2>商品分类</h2>
					<dl>
						<dt>图书音像</dt>
						<dd><a href="product-list.html">图书</a></dd>
						<dd><a href="product-list.html">音乐</a></dd>
						<dt>百货</dt>
						<dd><a href="product-list.html">运动健康</a></dd>
						<dd><a href="product-list.html">服装</a></dd>
						<dd><a href="product-list.html">家居</a></dd>
						<dd><a href="product-list.html">美妆</a></dd>
						<dd><a href="product-list.html">母婴</a></dd>
						<dd><a href="product-list.html">食品</a></dd>
						<dd><a href="product-list.html">手机数码</a></dd>
						<dd><a href="product-list.html">家具首饰</a></dd>
						<dd><a href="product-list.html">手表饰品</a></dd>
						<dd><a href="product-list.html">鞋包</a></dd>
						<dd><a href="product-list.html">家电</a></dd>
						<dd><a href="product-list.html">电脑办公</a></dd>
						<dd><a href="product-list.html">玩具文具</a></dd>
						<dd><a href="product-list.html">汽车用品</a></dd>
					</dl>
				</div>
				<div class="spacer"></div>
				<div class="last-view">
					<h2>最近浏览</h2>
					<dl class="clearfix">
						<dt><img src="${pageContext.request.contextPath}/images/product/0_tiny.gif"/></dt>
						<dd><a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a></dd>
						<dt><img src="${pageContext.request.contextPath}/images/product/0_tiny.gif"/></dt>
						<dd><a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a></dd>
					</dl>
				</div>
			</div>
			<div class="main">
				<h2>修改用户</h2>
				<div class="manage">
					<form action="${pageContext.request.contextPath}/user/update" method="post">
						<table class="form">
							<tr>
								<td class="field">用户 id（主键，只读）：</td>
								<td><input type="text" class="text" name="userId" value="${user.userId}" readonly="readonly"/></td>
							</tr>
							<tr>
								<td class="field">用户名：</td>
								<td><input type="text" class="text" name="userName" value="${user.userName}"/></td>
							</tr>
							<tr>
								<td class="field">密码：</td>
								<td><input type="text" class="text" name="passWord" value="${user.passWord}"/></td>
							</tr>
							<tr>
								<td class="field">收货地址：</td>
								<td><input type="text" class="text" name="location" value="${user.location}"/></td>
							</tr>
							<tr>
								<td class="field">手机号码：</td>
								<td><input type="text" class="text" name="phoneNumber" value="${user.phoneNumber}"/></td>
								<input type="hidden" name="page" value="user-modify"/>
							</tr>
							<tr>
								<td></td>
								<td><label class="ui-blue"><input type="submit" name="submit" value="更新"/></label></td>
							</tr>

						</table>
					</form>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div id="footer">
			Copyright &copy; 2022 All Rights Reserved. 京ICP证1000001号
		</div>
	</body>
</html>
