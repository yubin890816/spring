<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/15
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<body>
    ${hello}
    <form action="${ctp}/hello/hello2" method="post">
        <input type="text" name="userName" />
        <input type="submit" value="提交">
    </form>
</body>
</html>
