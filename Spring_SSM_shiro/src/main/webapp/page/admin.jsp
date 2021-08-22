<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%--设置根路径--%>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath() + "/";
    %>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
</head>
<body>
<div id="app">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row table-bordered" style="margin-top: 20px;line-height: 100px">
                    <div class="col-md-12 form-inline text-center">
                        <form id="searchFormId">
                            <input type="hidden" name="nowPage">
                            <input type="hidden" name="m" value="queryApp">
                            名称:<input type="text" placeholder="请输入软件名称" class="form-control" style="width: 150px" name="appName">
                            类型:
                            <select class="form-control" name="appType">
                                <option value="">请选择类型</option>
                                <option value="娱乐">娱乐</option>
                                <option value="办公">办公</option>
                            </select>
                            软件平台:
                            <select class="form-control" name="appPlatform">
                                <option value="">请选择平台</option>
                                <option value="魔方云">魔方云</option>
                                <option value="伙伴云">伙伴云</option>
                                <option value="云表">云表</option>
                                <option value="狐表">狐表</option>
                            </select>
                            审批状态:
                            <select class="form-control" >
                                <option value="">请选择状态</option>
                                <option value="魔方云">已审批</option>
                                <option value="伙伴云">未审批</option>
                            </select>
                            <button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-search"></span>搜索</button>
                            <button type="button" class="btn btn-primary">批量审批</button>

                        </form>
                    </div>
                </div>

                <div class="row" style="margin-top: 20px">
                    <table class="table-bordered col-md-12 text-center" >
                        <tr style="line-height: 50px">
                            <td><input type="checkbox" class="all"> 全选/全消</td>
                            <td>编号</td>
                            <td>名称</td>
                            <td>大小</td>
                            <td>类型</td>
                            <td>软件平台</td>
                            <td>下载次数</td>
                            <td>图片</td>
                            <td colspan="2">操作</td>
                        </tr>
                        <tbody>
                        <tr>
                            <td>选择<input type="checkbox" class="sel"></td>
                            <td>1</td>
                            <td>idea</td>
                            <td>600M</td>
                            <td>办公</td>
                            <td>魔方云</td>
                            <td>0次</td>
                            <td>
                                <img src="../images/app/1.png" width="50px">
                            </td>
                            <td>
                                <button class="btn btn-danger" type="button" >
                                    <span class="glyphicon glyphicon-remove"></span>驳回
                                </button>
                            </td>
                            <td>
                                <button   type="button" class="btn btn-primary" data-toggle="modal" data-target="#updateModal">
                                    <span class="glyphicon glyphicon-edit"></span>通过
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="text-center">
                    <ul class="pagination">
                        <li ><a href="javascript:void(0)">&laquo;</a></li>
                        <li><a href="javascript:void(0)">1</a></li>
                        <li><a href="javascript:void(0)">2</a></li>
                        <li><a href="javascript:void(0)">3</a></li>
                        <li><a href="javascript:void(0)">4</a></li>
                        <li ><a href="javascript:void(0)">&raquo;</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script type="text/javascript" src="../js/bootstrap.js"></script>
</body>
</html>
    