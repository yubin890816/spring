<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<body>
    <form action="${ctx}/dataValidate" method="post">
        编号: <input type="text" name="id">${errorMsg.id}<br/>
        姓名: <input type="text" name="name">${errorMsg.name}<br/>
        年龄: <input type="text" name="age">${errorMsg.age}<br/>
        生日: <input type="text" name="birthday">${errorMsg.birthday}<br/>
        邮箱: <input type="text" name="email">${errorMsg.email}<br/>
        省份: <input type="text" name="address.province">${errorMsg.province}<br/>
        城市: <input type="text" name="address.city">${errorMsg.city}<br/>
        区域: <input type="text" name="address.town">${errorMsg.town}<br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
