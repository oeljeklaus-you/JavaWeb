<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/6
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Update Customer</title>
</head>
<body>
    <form action="/updateCustomer">
        <input type="hidden" value="${customer.id}" name="id">
        Name:<input type="text" value="${customer.name}"><br>
        City:<input type="text" value="${customer.city}"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
