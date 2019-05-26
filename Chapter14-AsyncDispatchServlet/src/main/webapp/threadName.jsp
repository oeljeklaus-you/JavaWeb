<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2019/5/26
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Aysnchronous servlet</title>
</head>
<body>
    Main Thread:${mainThread}<br>
    Work Thread:${requestScope.workThread}
</body>
</html>
