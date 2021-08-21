<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <style type="text/css">
        .ul-aside-1 {
            margin-top: 200px;
        }

        .ul-aside-1 li a {
            color: white;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 text-center "
             style="background: black;color: white;line-height: 100px;font-size: 40px;font-weight: bold"> APP管理系统 <span
                style="position: absolute;color: white;right:100px;font-size: 20px"> 用户名:<shiro:principal/></span>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2" style="height:800px;background: gray">
            <ul class="text-center nav ul-aside-1 nav-stacked">
                <shiro:hasRole name="user">
                    <li><a href="/page/user.jsp" target="showFrame">普通用户</a></li>
                </shiro:hasRole>
                <shiro:hasRole name="manager">
                    <li><a href="/page/manager.jsp" target="showFrame">app管理</a></li>
                </shiro:hasRole>
                <shiro:hasRole name="admin">
                    <li><a href="/page/admin.jsp" target="showFrame">app审批</a></li>
                </shiro:hasRole>
                <li><a href="/logout">退出系统</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <iframe src="page/user.jsp" width="100%" height="800px" frameborder="0px" scrolling="0"
                    name="showFrame"></iframe>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
    