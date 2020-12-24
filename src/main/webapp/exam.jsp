<%--
  Created by IntelliJ IDEA.
  User: JamesTang
  Date: 2020/12/24
  Time: 4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Exam Page</title>
</head>
<body class="layui-body layui-bg-black">
<%
    String path=request.getContextPath();
    String basepath=request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/";
%>


<input name="userID" value="${requestScope.userId}" hidden="hidden"/>

<c:forEach var="P" items="${requestScope.papers}" varStatus="id">
<form action="examServlet" method="post" class="layui-form" id="pushInfo${id.count}">
    <div class="layui-container">
        <div class="layui-row">
            <div class="layui-col-md9">
                <div class="layui-form-label">
                    <label class="layui-form-label" >${P.paperID}. </label>${P.paperTitle}
                    <input name="subjectID${id.count}" value="${P.paperID}" hidden="hidden"/>
                </div>
                <div class="layui-field-box">A: ${P.optionA} B: ${P.optionB} C: ${P.optionC} D: ${P.optionD}</div>
                <input type="radio" name="option${id.count}" value="A" title="A" class="layui-form-radio"> A
                <input type="radio" name="option${id.count}" value="B" title="B" class="layui-form-radio"> B
                <input type="radio" name="option${id.count}" value="C" title="C" class="layui-form-radio"> C
                <input type="radio" name="option${id.count}" value="D" title="D" class="layui-form-radio"> D
            </div>
        </div>
    </div>
</form>
</c:forEach>

</body>
</html>
