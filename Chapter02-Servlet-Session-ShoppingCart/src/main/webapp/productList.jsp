<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/6
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>商品详情</title>
</head>
<body>
    <table border="1">
        <thead>
            <th>商品名</th>
            <th>商品详情</th>
            <th>价格</th>
            <th>编辑</th>
        </thead>
        <thead>
        <c:forEach items="${requestScope.products}" var="product">
            <tr>
                <td>${product.productName}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td><a href="/addProducts?id=${product.id}">添加到购物车</a></td>
            </tr>
        </c:forEach>

        </thead>
    </table>
</body>
</html>
