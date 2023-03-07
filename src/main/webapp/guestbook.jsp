<%@ page import="me.dingshuai.pojo.Users" %>
<%@ page import="me.dingshuai.dao.MessagesDao" %>
<%@ page import="me.dingshuai.dao.impl.MessagesDaoImpl" %>
<%@ page import="me.dingshuai.pojo.Messages" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>在线购物网 - 首页</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
	</head>
	<body>
		<div id="header" class="wrap">
			<div id="logo"><img src="${pageContext.request.contextPath}/images/logo.gif"/></div>
			<div class="help">

				<c:if test="${not empty user}">
					欢迎您，${user.username}
					<a href='user-modify.jsp'>修改个人信息</a>
					<a href='${pageContext.request.contextPath}/exit'>注销</a>
					<c:if test="${user.username == 'admin'}">
						<a href='manage/index.jsp'>进入管理后台</a>
					</c:if>
				</c:if>

				<c:if test="${empty user}">
					<a href='login.jsp'>登录</a>
					<a href='register.jsp'>注册</a>
				</c:if>

				<a href="${pageContext.request.contextPath}/showMsg">留言</a></div>
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
			您现在的位置：<a href="index.jsp">易买网</a> &gt; 在线留言
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
			</div>
			<div class="main">
				<div class="guestbook">
					<h2>全部留言</h2>
					<ul>
						<c:forEach items="${messages}" var="msg">
							<li>
								<dl>
									<dt>${msg.msgContent}</dt>
									<dd class='author'>
										网友：${msg.msgSender}
										<span class='timer'>标题：${msg.msgTitle}</span>&emsp;&nbsp;
										状态：${msg.msgStatus}
									</dd>
									<dd>${msg.msgReplyContent}</dd>
								</dl>
							</li>
						</c:forEach>
					</ul>
					<div class="clear"></div>
					<div class="pager">
						<ul class="clearfix">
							<li><a href="#">上一页</a></li>
							<li class="current">1</li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">下一页</a></li>
						</ul>
					</div>
					<div id="reply-box">
						<form action="shop/addMsg" method="post">
							<table>
								<tr>
									<td class="field">昵称：</td>
									<td><input class="text" type="text" name="guestName"/></td>
								</tr>
								<tr>
									<td class="field">留言标题：</td>
									<td><input class="text" type="text" name="guestTitle"/></td>
								</tr>
								<tr>
									<td class="field">留言内容：</td>
									<td><textarea name="guestContent"></textarea></td>
								</tr>
								<tr>
									<td></td>
									<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言"/></label></td>
								</tr>
							</table>
						</form>
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
