<%--
  Created by IntelliJ IDEA.
  shop.User: Kamil
  Date: 2018-12-02
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="cssStyle/createUser.css">
    <title>CreateUser</title>
</head>
<body>
    <main>
        <h3 id="header">Aby się zalgowac wypełnij formularz</h3>
        <form method="post" action="CreateUserServlet">
            <input type="text" name="create_name" placeholder="Imie"/>
            <input type="text" name="create_surname" placeholder="Nazwisko"/>
            <input type="text" name="create_userName" placeholder="UserName"/>
            <input type="text" name="create_password" placeholder="Password"/>
            <input type="submit" name="create_registry" value="Zarejestruj sie"/>
        </form>
        <form action="log.jsp" method="post">
            <input type="submit" value="Powrot do logowania"/>
        </form>
    </main>
</body>
</html>
