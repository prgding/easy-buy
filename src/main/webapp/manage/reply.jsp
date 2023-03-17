<%@ page contentType="text/html;charset=UTF-8" %>
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
			<h2>回复留言</h2>
			<div class='manage'>
				<form action='${pageContext.request.contextPath}/msg/replyMsg' method='post'>
					<table class='form'>

						<tr>
							<td class='field'>留言ID：</td>
							<td><input type='text' class='text' name='msgId' value='${message.msgId}' readonly='readonly'/></td>
						</tr>
						<tr>
							<td class='field'>留言姓名：</td>
							<td><input type='text' class='text' name='msgSender' value='${message.msgSender}'/></td>
						</tr>
						<tr>
							<td class='field'>留言内容：</td>
							<td><input type='text' class='text' name='msgContent' value='${message.msgContent}'/></td>
						</tr>
						<tr>
							<td class='field'>回复内容：</td>
							<td><textarea name='msgReplyContent'>${message.msgReplyContent}</textarea></td>
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
