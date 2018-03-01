<%--
  Created by IntelliJ IDEA.
  User: mutoulazy
  Date: 2018/3/1
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>listCategory</title>
</head>
<body>
    <div style="width:500px;margin:20px auto;text-align: center">
        <table align="center" border="1" cellspacing="0">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>edit</td>
                <td>delete</td>
            </tr>
            <c:forEach items="${pageList.content}" var="c" varStatus="st">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td><a href="editCategory?id=${c.id}">编辑</a></td>
                    <td><a href="deleteCategory?id=${c.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <%--为什么直接用问好接页码参数就可以自动补全url--%>
        <div>
            <a href="?start=0">[首  页]</a>
            <a href="?start=${pageList.number-1}">[上一页]</a>
            <a href="?start=${pageList.number+1}">[下一页]</a>
            <a href="?start=${pageList.totalPages-1}">[末  页]</a>
        </div>
        <br>
        <form action="addCategory" method="post">
            name: <input name="name"> <br>
            <button type="submit">提交</button>
        </form>
    </div>
</body>
</html>
