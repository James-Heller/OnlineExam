<%--
  Created by IntelliJ IDEA.
  User: JamesTang
  Date: 2020/12/23
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Management Page</title>
</head>
<body>
<%
    String path=request.getContextPath();
    String basepath=request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/";
%>
<c:forEach var="U" items="${requestScope.all}">
    <form action="updateScoreServlet" method="post">

        <div class="layui-container">

            <div class="layui-row">
                <div class="layui-col-md9">
                    <div class="layui-form-label">
                        <label class="layui-form-label">姓名：</label>
                    </div>
                    <div class="layui-input-block">
                        <input type="text" value="${U.name}" name="name" class="layui-input"/>
                    </div>

                    <div class="layui-form-label">
                        <label class="layui-form-label">邮箱：</label>
                    </div>
                    <div class="layui-input-block">
                        <input type="email" value="${U.ID}" name="id" class="layui-input"/>
                    </div>

                    <div class="layui-form-label">
                        <label class="layui-form-label">密码：</label>
                    </div>
                    <div class="layui-input-block">
                        <input type="password" value="${U.password}" name="password" readonly="readonly" class="layui-input"/>
                    </div>

                    <div class="layui-form-label">
                        <label class="layui-form-label">成绩：</label>
                    </div>
                    <div class="layui-input-block">
                        <input type="text" value="${U.score}" name="score" class="layui-input"/>
                        <input type="submit" value="更改" name="updatescore" class="layui-btn layui-btn-xs">
                    </div>
                </div>
            </div>
        </div>
    </form>
</c:forEach>
</body>
</html>
