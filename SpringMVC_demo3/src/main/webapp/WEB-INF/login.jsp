<%--
  Created by IntelliJ IDEA.
  User: rua
  Date: 2021/8/18
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--设置根路径--%>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath() + "/";
    %>
    <base href="<%=basePath%>">
        <title>Title</title>
</head>
<body>
<h1>注册页面</h1>
<a href="index.jsp">首页</a>
<a href="view/register">注册页面</a>

<hr>
<form action="user/login" method="post">
    用户名:<input type="text" name="uname"><br>
    密码:<input type="text" name="pwd"><br>
    <input type="radio" name="status" value="0"> 普通用户
    <input type="radio" name="status" value="1"> 管理员
    <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
