<%@ page import="shop.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Unlock" rel="stylesheet">
    <link rel="stylesheet" href="cssStyle/userCart.css">

    <title>userCart.jsp</title>
</head>
<body>
<h1 id="header">Here is your list with products...</h1>
<table id="tab">
    <tr id="thInProduct">
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    <%
        double suma = 0;
        List<Product>shoppingList = (List<Product>) request.getSession().getAttribute("productCart");
        for(Product product : shoppingList) {
            suma+=product.getPrice();
    %>
    <tr>
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getDescription()%></td>
        <td><%=product.getPrice()%></td>
        <td><%=product.getQuantity()%></td>
    </tr>
    <%}%>
</table>
<p id="totalPayment">Total Payment: <%=suma%></p>

<form class="outFormBtn" action="PaymentServlet"method="post">
    <input class="logOutBtn" type="submit" value="Payment"/>
</form>
<form class="outFormBtn" method="post" action="LogoutServlet">
    <input class="logOutBtn" type="submit" value="Log of">
</form>
</body>
</html>
