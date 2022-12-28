<%@ page import="java.util.List" %>
<%@ page import="me.dingshuai.dao.TmessagesDao" %>
<%@ page import="me.dingshuai.dao.impl.TmessagesDaoImpl" %>
<%@ page import="me.dingshuai.pojo.Tmessages" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>后台管理 - 在线购物网</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css"/>
    <script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="../images/logo.gif"/></div>
    <div class="help"><a href="../index.jsp">返回前台页面</a></div>
    <div class="navbar">
        <ul class="clearfix">
            <li><a href="index.jsp">首页</a></li>
            <li><a href="<%=request.getContextPath()%>/showUsers">用户</a></li>
            <li><a href="product.html">商品</a></li>
            <li><a href="order.html">订单</a></li>
            <li class="current"><a href="<%=request.getContextPath()%>/showMsg">留言</a></li>
            <li><a href="news.html">新闻</a></li>
        </ul>
    </div>
</div>
<div id="childNav">
    <div class='welcome wrap'>
        <%
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String format = formatter.format(now);
        %>
        管理员admin您好，今天是<%=format%>，欢迎回到管理后台。
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

        <%
            List<Tmessages> tmessages = (List<Tmessages>) session.getAttribute("tmessages");
			for (Tmessages tmessage : tmessages) {
        %>
                <tr>
                    <td class='first w4 c'><%=tmessage.getMsgId()%></td>
                    <td class='w1 c'><%=tmessage.getMsgSender()%></td>
                    <td class='w4 c'><%=tmessage.getMsgContent()%></td>
                    <td class='w3 c'><%=tmessage.getMsgStatus()%></td>
                    <td class='w1 c'>
                        <a href='<%=request.getContextPath()%>/reply?msgId=<%=tmessage.getMsgId()%>'>回复</a>
                        <a href='javascript:DeleteMsg(<%=tmessage.getMsgId()%>);'>删除</a>
                    </td>
                </tr>
        <%}%>

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
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2022 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
