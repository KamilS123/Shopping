<%@ page import="java.util.List" %>
<%@ page import="shop.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Unlock" rel="stylesheet">
    <link rel="stylesheet" href="cssStyle/productList.css">
    <title>productList.jsp</title>
</head>
<body>
<%
    String userName = "";
    Cookie[]cookies = request.getCookies();
    if(cookies!=null) {
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("user_cookie")) {
                userName = cookie.getValue();
            }
        }
    }
    if(userName==null) {
        response.sendRedirect("log.jsp");
    }
%>
<h1 id="header">List of offered products...</h1>
<table id="tab">
    <tr id="thInProduct">
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    <%
        List<Product>lisWithProducts = (List<Product>) request.getSession().getAttribute("productList");

        List<Product>newCartList = new ArrayList<Product>();
        for(Product product : lisWithProducts) {
    %>
    <form action="ShoppingCartServlet" method="post">
    <tr>
        <td><input type="text" name="produkt_<%=product.getId()%>" value="<%=product.getId()%>" readonly/></td>
        <td><%=product.getName()%></td>
        <td><%=product.getDescription()%></td>
        <td><%=product.getPrice()%></td>
        <td><%=product.getQuantity()%></td>
        <td>
                <input id="add" type="submit" value="Add"/>
        </td>
    </tr>
    </form>
    <%}%>
</table>
    <form id="outFormBtn" action="userCart.jsp" method="post">
        <input class="logOutBtn" type="submit" value="Go to my cart"/>
    </form>
    <form id="outFormBtn" action="LogoutServlet" method="post">
        <input class="logOutBtn" type="submit" value="Log out"/>
    </form>
</body>
</html>
