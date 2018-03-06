<%--
  Created by IntelliJ IDEA.
  User: mutoulazy
  Date: 2018/3/2
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadFile</title>
</head>
<body>
    <form action="upload" method="post" enctype="multipart/form-data">
        选择图片：<input type="file" name="file" accept="image/*">
        <input type="submit" value="上传">
    </form>
    <div>
        ${fileName}
    </div>
</body>
</html>
