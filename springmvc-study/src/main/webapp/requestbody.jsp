<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.9.1.min.js"></script>
</head>
<%
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<body>

    <form action="${ctx}/testRequestBody" method="post">
        <input type="text" name="userName" value="zhangsan"/><br/>
        <input type="text" name="password" value="123456"/><br/>
        <input type="submit" value="提交"/>
    </form>
    <hr/>
    <a href="#">发送json数据</a>
</body>
</html>
<script>
    $("a").click(function () {
        var user = {id: 1, userName: "张三", password: "123456", age: 18};
        var jsonStr = JSON.stringify(user);
        $.ajax({
            <%--url: "${ctx}/testRequestBody",--%>
            url: "${ctx}/testRequestJson",
            type: "POST",
            data: jsonStr,
            contentType: "application/json",
            success: function (data) {
                alert(data);
            }
        });
    });
</script>
