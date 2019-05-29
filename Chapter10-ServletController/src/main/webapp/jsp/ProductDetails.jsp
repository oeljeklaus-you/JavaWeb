<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2019/5/29
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>ProductDetails</title>
</head>
<body>
<div id="gobal">
    <h4>The product has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Product Name:${product.name}<br/>
        Description:${product.description}<br/>
        Price:$${product.price}
    </p>
</div>
</body>
</html>
