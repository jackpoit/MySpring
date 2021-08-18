
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
<h2>@RequestMapping使用</h2>
<a href="test/demo1">测试SpringMVC路由映射1</a><br>
<a href="test/demo2">测试SpringMVC路由映射2</a><br>
<a href="test/demo3?name=admin">测试SpringMVC路由映射3</a><br>

<h2>请求参数的封装</h2>
<a href="param/servlet_api?uname=admin&pwd=123">使用传统的ServletAPI来接受请求参数</a><br>
<a href="param/test1?uname=admin&pwd=123&salary=123">约定优于编程I来接受请求参数</a><br>

<form action="param/test3" method="post">
    昵称:<input type="text" name="uname"/><br>
    真实姓名:<input type="text" name="realname"/><br>
    密码:<input type="password" name="pwd"/><br>
    性别:<input type="radio" name="gender" value="0"/>男
        <input type="radio" name="gender" value="1" checked/>女
    <br>
    生日:<input type="date" name="birthday">      <%--2019-02-19--%>
    <button type="submit">注册</button>
</form>

<hr>
如何批量上传
<form action="param/test4" method="post">
    昵称:<input type="text" name="list[0].uname"/>
    密码:<input type="password" name="list[0].pwd"/><br>
    昵称:<input type="text" name="list[1].uname"/>
    密码:<input type="password" name="list[1].pwd"/><br>
    昵称:<input type="text" name="list[2].uname"/>
    密码:<input type="password" name="list[2].pwd"/><br>
    <button type="submit">注册</button>
</form>

<hr>
<a href="param/test6?a=jack&b=666&c=1">请求参数混淆</a><br>
<a href="param/one_page?page=1">第一页</a><br>
<a href="param/one_page?page=2">第二页</a><br>
<a href="param/one_page">默认查询第一页</a><br>

<hr>
<a href="param/test7/jack/666/1">restful风格路由测试</a><br>

<a href="param/list/020000,java,2?lang=php">模拟51job的restful风格1</a><br>

<a href="param/one/020000,java,2?lang=php&type=post">模拟51job的restful风格2</a><br>

<hr>
如何批量上传
<form action="param/test5" method="post">
    <input type="checkbox" name="hobbys" value="篮球">篮球 <br>
    <input type="checkbox" name="hobbys" value="足球">足球 <br>
    <input type="checkbox" name="hobbys" value="乒乓球">乒乓球 <br>
    <input type="checkbox" name="hobbys" value="台球">台球 <br>
    <button type="submit">注册</button>
</form>
</body>
</html>
