<%--
  Created by IntelliJ IDEA.
  User: rua
  Date: 2021/8/19
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>用户登录首页</h1>
    <form action="/login" method="post">
        用户名: <input type="text" name="userNo">
        密码: <input type="text" name="userPass">
        <input type="submit" value="login">
    </form>
    <a href="/logout">注销</a>

    <hr>
    <form action="/register" method="post">
        用户名: <input type="text" name="userNo"><br>
        密码: <input type="text" name="userPass"><br>
        <input type="submit" value="register"><br>
    </form>

</body>
</html>
