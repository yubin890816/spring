<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<html>
<body>
    <h2>Hello World!</h2>
    <form action="${ctx}/rest/user" method="post">
        <input type="submit" value="新增">
    </form>
    <form action="${ctx}/rest/user/1" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="删除">
    </form>
    <form action="${ctx}/rest/user/1" method="post">
        <input type="hidden" name="_method" value="put">
        <input type="submit" value="修改">
    </form>
    <a href="${ctx}/rest/user">查询</a>
</body>
</html>
