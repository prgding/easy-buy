<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id='header' class='wrap'>
    <div class='help'><a href='${pageContext.request.contextPath}/index.jsp'>返回前台页面</a></div>
    <div class='navbar'>
        <ul class='clearfix'>
            <li><a href='${pageContext.request.contextPath}/manage/index.jsp'>首页</a></li>
            <li><a href='${pageContext.request.contextPath}/user/showUsersForAdmin'>用户</a></li>
            <li><a href='${pageContext.request.contextPath}/msg/showAllMsgsForAdmin'>留言</a></li>
        </ul>
    </div>
</div>
<div id='childNav'>
    <div class='welcome wrap'>
        管理员admin您好，今天是${date}，欢迎回到管理后台。
    </div>
</div>