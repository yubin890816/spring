<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/16
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>静态资源的访问</title>
</head>
<%
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<body>
    <div>访问静态资源</div>
    <img src="${ctx}/images/1.png">
</body>
</html>
