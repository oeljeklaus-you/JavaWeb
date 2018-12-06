<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/6
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
    <table border="1">
        <thead>
            <th>商品名</th>
            <th>商品详情</th>
            <th>购买数量</th>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.shoppingItems}" var="item">
                <tr>
                    <td>${item.product.productName}</td>
                    <td>${item.product.description}</td>
                    <td>${item.quantity}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
