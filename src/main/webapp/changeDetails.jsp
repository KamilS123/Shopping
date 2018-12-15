<%--
  Created by IntelliJ IDEA.
  User: Kamil
  Date: 2018-12-15
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>changeDetails.jsp</title>
</head>
<body>
<form method="post" action="ChangeDetailsServlet">
    <input type="text" name="name" placeholder="Name"/>
    <input type="text" name="surname" placeholder="Surname"/>
    <input type="text" name="userName" placeholder="UserName"/>
    <input type="password" name="password" placeholder="Password"/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
