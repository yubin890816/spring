<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/18
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异常处理器案例演示</title>
</head>
<%
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<body>
    <a href="${ctx}/exception">异常处理器演示</a>
</body>
</html>
