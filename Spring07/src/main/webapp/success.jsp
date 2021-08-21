<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rua
  Date: 2021/8/19
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>登录成功</h3>

<hr>

<shiro:authenticated>
    <span>欢迎:<shiro:principal/></span>
    <a href="/logout">注销</a>

</shiro:authenticated>
<hr>
<shiro:hasRole name="user">
    <a href="/page/add.jsp">add</a><br>

</shiro:hasRole>
<shiro:hasRole name="manager">
    <a href="/page/list.jsp">list</a><br>
</shiro:hasRole>
</body>
</html>
