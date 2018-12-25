<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/25
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多文件上传</title>
</head>
<body>
<form action="/doMultipartFileUpServlet" enctype="multipart/form-data" method="post">
    选择文件:<input type="file" name="filename" multiple="multiple"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
