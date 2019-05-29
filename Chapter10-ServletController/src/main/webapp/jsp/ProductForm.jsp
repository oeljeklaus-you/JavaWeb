<%--
  Created by IntelliJ IDEA.
  User: youyujie
  Date: 2019/5/29
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductForm</title>
</head>
<body>
    <div>
        <h3>Add a product</h3>
        <form method="post" action="product_save">
            <table>
                <tr>
                    <td>Product Name:</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><input type="text" name="description"/></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price"/></td>
                </tr>
                <tr>
                    <td><input type="reset"/></td>
                    <td><input type="submit" name="Add Product"/></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
