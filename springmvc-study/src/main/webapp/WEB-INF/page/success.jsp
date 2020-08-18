<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    System.out.println("页面开始执行");
%>
<body>
    SUCCESS <br>
    <%--request:${requestScope.request} <br>--%>
    request:${requestScope.get("request")} <br>
    <%--session: ${sessionScope.session}--%>
    session: ${sessionScope.get("session")}
</body>
</html>
