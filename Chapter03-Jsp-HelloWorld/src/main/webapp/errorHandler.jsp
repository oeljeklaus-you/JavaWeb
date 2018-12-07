<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/7
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true"%>
<html>
<head>
    <title>Error</title>
</head>
<body>
    Error message:
    <%
        out.print(exception.toString());
    %>
</body>
</html>
