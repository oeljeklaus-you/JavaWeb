<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/6
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <form action="/loginServlet" method="post">
        Name:<input type="text" name="name"><br>
        Pwd:<input type="password" name="passwd"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
