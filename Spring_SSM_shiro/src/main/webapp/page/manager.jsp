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
    <script type="text/javascript" src="../js/showImg.js"></script>
</head>
<body>
<div id="app">
    <!--1.添加的模态框-->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog"  aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">添加app</h4>
                </div>
                <div class="modal-body">
                    <form class="text-center form-inline" id="addFormId">
                        <input type="hidden" name="m" value="addApp">

                        <p>
                            <img src="" height="100px" width="100px" id="addImg">
                        </p>

                        <p>
                            app名称:<input type="text" name="appName" class="form-control" style="width:400px" placeholder="请输入app名称">
                        </p>
                        <p>
                            app大小:<input type="text" name="appSize" class="form-control" style="width:400px" placeholder="请输入大小">
                        </p>
                        <p>
                            app类型:
                            <select class="form-control" style="width:400px" name="appType">
                                <option value="">请选择类型</option>
                                <option value="娱乐">娱乐</option>
                                <option value="办公">办公</option>
                            </select>
                        </p>
                        <p>
                            app平台:
                            <select class="form-control" style="width:400px" name="appPlatform">
                                <option value="">请选择平台</option>
                                <option value="魔方云">魔方云</option>
                                <option value="伙伴云">伙伴云</option>
                                <option value="云表">云表</option>
                                <option value="狐表">狐表</option>
                            </select>
                        </p>

                        <p>
                            下载次数:<input type="number" name="appCount" min="0" value="0" class="form-control" style="width:400px" placeholder="请输入下载次数" readonly>
                        </p>

                        <p>
                            app图片:<input type="file" onchange="getImg(this,addImg)" name="appImg" class="form-control" style="width:400px"  >
                        </p>

                        <p>
                            <button type="button" class="btn btn-info" @click="addApp()">确认添加</button>
                            <button type="button" class="btn btn-info" data-dismiss="modal">返回首页</button>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <!--2.修改的模态框-->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog"  aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">修改app</h4>
                </div>
                <div class="modal-body">
                    <form class="text-center form-inline" id="updateFormId">
                        <p>
                            <img src="" height="100px" width="100px" id="updateImg">
                        </p>
                        <p>
                            app编号:<input readonly  type="text" name="id" class="form-control" style="width:400px" placeholder="请输入app编号">
                        </p>
                        <p>
                            app名称:<input type="text" name="appName" class="form-control" style="width:400px" placeholder="请输入app名称">
                        </p>
                        <p>
                            app大小:<input type="text" name="appSize" class="form-control" style="width:400px" placeholder="请输入大小">
                        </p>
                        <p>
                            app类型:
                            <select class="form-control" style="width:400px" name="appType">
                                <option>请选择类型</option>
                                <option>娱乐</option>
                                <option>办公</option>
                            </select>
                        </p>
                        <p>
                            app平台:
                            <select class="form-control" style="width:400px" name="appPlatform">
                                <option>魔方云</option>
                                <option>伙伴云</option>
                                <option>云表</option>
                                <option>狐表</option>
                            </select>
                        </p>
                        <p>
                            下载次数:<input type="number" name="appCount" min="0" value="0" class="form-control" style="width:400px" placeholder="请输入下载次数" readonly>
                        </p>
                        <p>
                            app图片:<input type="file" onchange="getImg(this,updateImg)" name="appImg" class="form-control" style="width:400px" >
                        </p>

                        <p>
                            <button type="button" class="btn btn-info">确认修改</button>
                            <button type="button" class="btn btn-info" data-dismiss="modal">返回首页</button>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row table-bordered" style="margin-top: 20px;line-height: 100px">
                    <div class="col-md-8 form-inline text-center">
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
                            <input type="button" class="btn btn-primary" value="搜索" @click="searchApp()">
                        </form>
                    </div>

                    <div class="col-md-4 navbar-right text-center">
                        <button type="button" class="btn btn-warning " >
                            <span class="glyphicon glyphicon-plus"></span>批量删除
                        </button>
                        <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#addModal">
                            <span class="glyphicon glyphicon-plus"></span>添加
                        </button>
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
                            <td>100次</td>
                            <td>
                                <img src="../images/app/1.png" width="50px">
                            </td>
                            <td>
                                <button class="btn btn-danger" type="button" >
                                    <span class="glyphicon glyphicon-remove"></span>删除
                                </button>
                            </td>
                            <td>
                                <button   type="button" class="btn btn-primary" data-toggle="modal" data-target="#updateModal">
                                    <span class="glyphicon glyphicon-edit"></span>修改
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
    