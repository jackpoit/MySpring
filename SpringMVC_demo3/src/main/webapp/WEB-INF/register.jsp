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
</body>
</html>
