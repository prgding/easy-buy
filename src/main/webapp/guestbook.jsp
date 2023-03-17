<%@ page import="me.dingshuai.pojo.User" %>
<%@ page import="me.dingshuai.mapper.MsgMapper" %>
<%@ page import="me.dingshuai.pojo.Message" %>
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
			<div class="help">
				<c:if test="${not empty user}">
					欢迎您，${user.userName}
					<a href='user-modify.jsp'>修改个人信息</a>
					<a href='${pageContext.request.contextPath}/exit'>注销</a>
					<c:if test="${user.userName == 'admin'}">
						<a href='${pageContext.request.contextPath}/manage/index.jsp'>进入管理后台</a>
					</c:if>
				</c:if>
				<c:if test="${empty user}">
					<a href='login.jsp'>登录</a>
					<a href='register.jsp'>注册</a>
				</c:if>
				<a href="${pageContext.request.contextPath}/msg/showAllMsgsForUser">留言</a></div>
		</div>

		<div id="main" class="wrap">
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
						<form action="msg/addMsg" method="post">
							<table>
								<tr>
									<td class="field">昵称：</td>
									<td><input class="text" type="text" name="msgSender"/></td>
								</tr>
								<tr>
									<td class="field">留言标题：</td>
									<td><input class="text" type="text" name="msgTitle"/></td>
								</tr>
								<tr>
									<td class="field">留言内容：</td>
									<td><textarea name="msgContent"></textarea></td>
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
