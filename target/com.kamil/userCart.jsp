<%@ page import="shop.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userCart.jsp</title>
</head>
<body>
    <%
        List<Product>shoppingList = (List<Product>) request.getSession().getAttribute();
    %>
</body>
</html>
