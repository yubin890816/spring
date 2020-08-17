<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/17
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传案例演示</title>
</head>
<%
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<body>
    <form action="${ctx}/upload" method="post" enctype="multipart/form-data">
        描述: <input type="text" name="desc"/><br><br>
        文件: <input type="file" name="file"/><br><br>
        文件: <input type="file" name="file"/><br><br>
        文件: <input type="file" name="file"/><br><br>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
