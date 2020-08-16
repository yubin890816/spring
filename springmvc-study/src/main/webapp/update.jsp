<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<body>
    <form action="${ctx}/student/update1" method="post">
        <input type="hidden" name="id" value="1" /><br/>
        姓名: 张三<br/>
        密码: <input type="text" name="password" /><br/>
        年龄: <input type="number" name="age" /><br/>
        <input type="submit" value="提交" />
    </form>
</body>
</html>
