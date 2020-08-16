<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/16
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自定义参数解析器</title>
</head>
<%
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<body>
    请遵循id-userName-password-age的方式进行传值<br/>
    <form action="${ctx}/testConverter">
        <input type="text" name="student" /><br/>
        <input type="submit" value="提交" />
    </form>
</body>
</html>
