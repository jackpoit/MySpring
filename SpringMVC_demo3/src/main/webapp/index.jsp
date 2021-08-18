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
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

<form action="ajax/test1" method="post">
    <input type="text" name="uname" placeholder="username"><br>
    <input type="text" name="pwd" placeholder="password"><br>
    <input type="submit"/>
</form>
<hr>
<span id="s1">发送ajax请求</span><br>
<span id="s2">发送ajax字符串请求</span><br>
<span id="s3">发送get异步请求</span><br>
<span id="s4">测试开发专用ajax接收及返回json处理</span><br>

<script>
    //先让页面加载,加载完执行此脚本
    $(function () {
        $('#s4').click(function () {
            $.post("test/ajax4",{},function (data) {
               alert(data)
            },"json")
        })
        $('#s3').click(function () {
            $.get("ajax/test5",{},function (data) {
                alert(data.msg)
                alert(data.content)
                alert(data.status)
                // alert(user.id+","+user.uname+","+user.realname)
            },"json")

        })
        $('#s2').click(function () {
            let jsonObj={"uname":"admin","pwd":123,"realname":"管理员"}//json对象
            $.ajax({
                url: 'ajax/test4',
                type: 'post',
                data: JSON.stringify(jsonObj),
                contentType:"application/json;charset=utf-8",//设置请求体编码方式
                dataType: "json",
                success: function (list) {
                    for (let i = 0; i < list.length; i++) {
                        alert(list[i].id+","+list[i].uname+","+list[i].realname)
                    }

                },
                error: function () { //url没有映射,服务器返回类型与接受类型不一致,服务器的一切异常
                    alert("请求error")
                }
            })
        })
        $('#s1').click(function () {
            $.ajax({
                url: 'ajax/test2',
                type: 'get',
                data: {"uname":"admin","pwd":123},
                dataType: "json",
                success: function (list) {
                    for (let i = 0; i < list.length; i++) {
                        alert(list[i].id+","+list[i].uname+","+list[i].realname)
                    }

                },
                error: function () { //url没有映射,服务器返回类型与接受类型不一致,服务器的一切异常
                    alert("请求error")
                }
            })
        })

    })


    let test = function () {
        let a = {uname: "admin", pwd: "123"}; //js对象
        let b = {"uname": "admin", "pwd": "123"}; //json对象[键必须是字符串]
        let c = JSON.stringify(b);   //将json对象转换成json字符串

        let d = '{"uname":"admin","pwd":"123"}'; //json字符串
        let e = JSON.parse(d);//将字符串解析成json对象
        console.log(e.uname);
    }
</script>

</body>
</html>
