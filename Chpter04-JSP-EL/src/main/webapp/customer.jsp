<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/8
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Customer Detail</title>
</head>
<body>
    <h1>Accpet-Language:${header["accept-language"]}</h1><br>
    <h1>Customer Name:${requestScope.customer.name}</h1><br>
    <h1>${customer.address.city}</h1><br>
    <h1>${pageContext.session.id}</h1><br>
    <h1>sessionId:${pageContext.session.id}</h1>
</body>
</html>
