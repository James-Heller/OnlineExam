<%--
  Created by IntelliJ IDEA.
  User: JamesTang
  Date: 2020/12/23
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registry Page</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
</head>

<body  class="layui-bg-black">

<div class="layui-bg-gray" style=" width: 625px; height: 250px; margin-left: auto; margin-right: auto; margin-top: 225px; border: 3px; border-radius: 4px">

    <form class="layui-form" action="registerServlet"method="post">

        <div class="layui-form-item" >
            <label class="layui-form-label" style="top: 10px">账户：</label>
            <div class="layui-input-block" style="top: 10px">
                <input type="text" name="id" placeholder="请输入账号" class="layui-input" style="width:500px;" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="top: 10px">密码：</label>
            <div class="layui-input-block" style="top: 10px">
                <input type="password" name="password" placeholder="Password" class="layui-input" style="width: 500px">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="top:10px">姓名：</label>
            <div class="layui-input-block" style="top: 10px">
                <input type="text" name="name" class="layui-input" style="width: 500px">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-row">
                <input type="submit" value="注册" class="layui-btn layui-btn-fluid"/>
            </div>
        </div>
    </form>

</div>
</body>
</html>