<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/6
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
    <table>
        <thead>
            <th>ID</th>
            <th>Name</th>
            <th>City</th>
            <th>Edit</th>
        </thead>
        <tbody>
            <c:forEach items="${cutomers}" var="cutomer">
                <tr><td>${cutomer.id}</td></tr>
                <tr><td>${cutomer.name}</td></tr>
                <tr><td>${cutomer.city}</td></tr>
                <tr><td><a href="/editCustomer?id=${cutomer.id}">Edit</a></td></tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
