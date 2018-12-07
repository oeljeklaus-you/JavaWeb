<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2018/12/7
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat" %>
<html>
<head>
    <title>今天的时间</title>
</head>
<body>
    <%
        DateFormat  dateFormat=DateFormat.getDateInstance(DateFormat.LONG);
        String s=dateFormat.format(new Date());
        System.out.println(s);
        out.println(s);

    %>
    <%
        //使用这条语句类似于在request域保存属性
        pageContext.setAttribute("name","zhangsan",PageContext.REQUEST_SCOPE);
    %>
</body>
</html>
