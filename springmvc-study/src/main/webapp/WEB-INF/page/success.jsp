<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/15
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    SUCCESS <br>
    <%--request:${requestScope.request} <br>--%>
    request:${requestScope.get("request")} <br>
    <%--session: ${sessionScope.session}--%>
    session: ${sessionScope.get("session")}
</body>
</html>
