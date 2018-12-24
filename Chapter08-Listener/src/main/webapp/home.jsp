<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/24
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <c:forEach var="country" items="${countries}">
        ${country.key}|${country.value} <br>
    </c:forEach>
</body>
</html>
