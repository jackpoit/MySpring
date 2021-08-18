<%--
  Created by IntelliJ IDEA.
  User: rua
  Date: 2021/8/18
  Time: 23:16
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
    <h1>Spring文件上传</h1>
    <%--
        文件上传 3个点
    --%>
    <form action="file/upload" method="post" enctype="multipart/form-data">
        <input type="text" name="uname" placeholder="username">
        <input type="file" name="myfile">
        <input type="submit" value="开始上传">
    </form>
</body>
</html>
