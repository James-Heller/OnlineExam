<%--
  Created by IntelliJ IDEA.
  User: JamesTang
  Date: 2020/12/23
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login success</title>
</head>
<body class="layui-body ">

<%
    String path=request.getContextPath();
    String basepath=request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/";
%>



<a href="managementServlet">教师入口</a>


<a href="#">学生入口</a>


</body>
</html>