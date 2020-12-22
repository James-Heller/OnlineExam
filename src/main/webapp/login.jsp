<%--
  Created by IntelliJ IDEA.
  User: JamesTang
  Date: 2020/12/22
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Please Login First</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
</head>

<body  class="layui-bg-black">

<div class="layui-bg-gray" style=" width: 625px; height: 250px; margin-left: auto; margin-right: auto; margin-top: 225px; border: 3px; border-radius: 4px">

    <form class="layui-form" action="loginServlet">

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
            <div class="layui-row">
                <input type="submit" value="登录" class="layui-btn layui-btn-fluid"/>
            </div>
        </div>
    </form>

    <form action="register.jsp">
        <div class="layui-row">
            <input type="submit" value="注册" class="layui-btn layui-btn-fluid layui-btn-primary"/>
        </div>
    </form>

</div>
</body>
</html>
