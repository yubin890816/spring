<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax请求</title>
    <script src="js/jquery-1.9.1.min.js"></script>
</head>
<%
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<body>
    <a href="#">获取学生信息</a>
    <div></div>
</body>
</html>
<script>
    $("a:first").click(function () {
        $.ajax({
            url: "${ctx}/testJson1",
            type: "GET",
            success: function (data) {
                $.each(data,function () {
                    var user = this.id + "---" + this.userName + "---" + this.password + "---" + this.age;
                    $("div").append(user + "<br/>");
                })
            }
        });
    });
</script>
