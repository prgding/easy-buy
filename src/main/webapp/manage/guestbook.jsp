<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
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
			<h2>留言管理</h2>
			<div class="manage">
				<table class="list">
					<tr>
						<th>msgId</th>
						<th>姓名</th>
						<th>留言内容</th>
						<th>状态</th>
						<th>操作</th>
					</tr>

					<c:forEach items="${messages}" var="message">
						<tr>
							<td class='first w4 c'>${message.msgId}</td>
							<td class='w1 c'>${message.msgSender}</td>
							<td class='w4 c'>${message.msgContent}</td>
							<td class='w3 c'>${message.msgStatus}</td>
							<td class='w1 c'>
								<a href='${pageContext.request.contextPath}/msg/showOneMsgForReply?msgId=${message.msgId}'>回复</a>
								<a href='javascript:DeleteMsg(${message.msgId});'>删除</a>
							</td>
						</tr>
					</c:forEach>

				</table>
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
			</div>
		</div>
	</div>
</body>
</html>
