<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="me.dingshuai.pojo.Tusers" %>
<%
    Tusers user = (Tusers) session.getAttribute("user");
%>
<html>
<head>
    <title>个人信息</title>
    <style>
        label {
            font-weight: bold;
            margin-right: 10px;
        }
        form {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            box-shadow: 2px 2px 2px #ccc;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #0088cc;
            border: none;
            color: #fff;
            font-weight: bold;
            cursor: pointer;
        }
        #popup {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
    </style>
</head>
<body>
<h1 align="center">个人信息查看、修改</h1>
<form action="updateUser" method="post">
    <label>用户 id （数据库主键，已设为只读）:</label>
    <input type="text" name="userId" value="<%=user.getUserId()%>" readonly><br>
    <label>用户名:</label>
    <input type="text" name="userName" value="<%=user.getUsername()%>"><br>
    <label>密码:</label>
    <input type="text" name="passWord" value="<%=user.getPassword()%>"><br>
    <label>收货地址:</label>
    <input type="text" name="location" value="<%=user.getLocation()%>"><br>
    <label>手机号码:</label>
    <input type="text" name="phoneNumber" value="<%=user.getPhoneNumber()%>"><br>
    <br>
    <input type="submit" value="保存修改">
</form>
<%--<h1 align="center" ><a href="index.jsp" >返回首页</a></h1>--%>
</body>
</html>

<script>
    document.querySelector("input[type=submit]").addEventListener("click", function() {
        alert("保存成功！");
    });
</script>
