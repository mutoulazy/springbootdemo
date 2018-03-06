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
    <%--spring boot 默认静态资源在static文件目录下--%>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <%--问题：在配置文件中修改静态文件目录到webapp下，并且进行静态文件设置--%>
</head>
<body>
    <script type="text/javascript">
        /*将post method 改变为delete*/
        $(function(){
            $(".delete").click(function () {
              var href = $(this).attr("href");
              $("#formdelete").attr("action",href).submit();
              return false;
           })
        })
    </script>
    <div align="center">

    </div>
    <div style="width:500px;margin:20px auto;text-align: center">
        <table align="center" border="1" cellspacing="0">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>edit</td>
                <td>delete</td>
            </tr>
            <%--jpa ${pageList.list}--%>
            <c:forEach items="${pageList.content}" var="c" varStatus="st">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td><a href="category/${c.id}">编辑</a></td>
                    <td><a class="delete" href="category/${c.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <%--为什么直接用问好接页码参数就可以自动补全url--%>
        <%--Jpa的分页--%>
        <div>
            <a href="?start=0">[首  页]</a>
            <a href="?start=${pageList.number-1}">[上一页]</a>
            <a href="?start=${pageList.number+1}">[下一页]</a>
            <a href="?start=${pageList.totalPages-1}">[末  页]</a>
        </div>

        <%--PageHelper的分页--%>
        <%--<div>--%>
            <%--<a href="?start=1">[首  页]</a>--%>
            <%--<a href="?start=${pageList.pageNum-1}">[上一页]</a>--%>
            <%--<a href="?start=${pageList.pageNum+1}">[下一页]</a>--%>
            <%--<a href="?start=${pageList.pages}">[末  页]</a>--%>
        <%--</div>--%>
        <br>
        <form action="category" method="post">
            <input type="hidden" name="_method" value="PUT">
            name: <input name="name"> <br>
            <button type="submit">提交</button>
        </form>

        <%--这个地方把删除替换层delete方法--%>
        <form id="formdelete" action="" method="POST" >
            <input type="hidden" name="_method" value="DELETE">
        </form>
    </div>
</body>
</html>
