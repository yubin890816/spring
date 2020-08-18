<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>国际化登录页面</title>
</head>
<%
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<body>
    <h1><fmt:message key="welcomeinfo"></fmt:message></h1>
    <form action="${ctx}/login" method="post">
        <fmt:message key="username"/>: <input type="text" name="userName"/><br/>
        <fmt:message key="password"/>: <input type="text" name="password"/><br/>
        <input type="submit" value="<fmt:message key="loginbtn"/>" />
    </form>
    <div><a href="${ctx}/i18n?locale=zh_CH">中文</a></div>
    <div><a href="${ctx}/i18n?locale=en_US">英文</a></div>
</body>
</html>
