<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>国际化操作演示</title>
</head>
<%
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<body>
    <a href="${ctx}/i18n">国际化页面登录</a>
</body>
</html>
