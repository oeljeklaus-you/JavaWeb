<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
    <c:if test="${empty name}">
            <jsp:forward page="/login"/>
    </c:if>
    <c:if test="${!empty name}">
        <a href="/showBooks">查看所有的书籍</a>
    </c:if>
</body>
</html>
