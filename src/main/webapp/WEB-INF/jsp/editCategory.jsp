<%--
  Created by IntelliJ IDEA.
  User: mutoulazy
  Date: 2018/3/1
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editCategory</title>
</head>
<body>
    <div style="margin: 0px auto; width: 500px">
        <form action="../category/${category.id}" method="post">
            name: <input name="name" value="${category.name}"> <br>
            <input name="id" type="hidden" value="${category.id}">
            <button type="submit">提交</button>
        </form>
    </div>
</body>
</html>
