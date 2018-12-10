<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/10
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>所有的书籍</title>
</head>
<body>
    <table border="1" cellpadding="0" cellspacing="0">
        <thead>
            <tr>
                <th>序号</th>
                <th>ISBN码</th>
                <th>书籍名称</th>
                <th>书籍描述</th>
                <th>书籍价格</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.books}" var="book" varStatus="status">
                <tr >
                    <td>${status.count}</td>
                    <td>${book.ISBN}</td>
                    <td>${book.title}</td>
                    <td>${book.description}</td>
                    <td>${book.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
