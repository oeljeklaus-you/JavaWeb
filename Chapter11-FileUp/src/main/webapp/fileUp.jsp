<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/25
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="/doFileUpServlet" enctype="multipart/form-data" method="post">
        文件 <input type="file" name="fileName"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
