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
<p>欢迎，${requestScope.userId}</p>
<c:set var="admin" scope="page" value="${requestScope.user}"/>
<c:if test="${admin}" >
    <a href="managementServlet" id="admin">教师入口</a>
</c:if>
<c:if test="${!admin}">
    <a href="getExamServlet" id="student" >学生入口</a>
</c:if>


</body>
</html>