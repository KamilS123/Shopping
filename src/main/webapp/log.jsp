<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Unlock" rel="stylesheet">
    <link rel="stylesheet" href="cssStyle/log.css">
    <title>LogForm</title>
</head>
<body>
<h1>Welcome in my shop. Please Sign in.</h1>
    <div id="container">
        <form method="post" action="LoginServlet">
            <input type="text" name="name" placeholder="Imie"/>
            <input type="text" name="surname" placeholder="Nazwisko"/>
            <input type="password" name="code" placeholder="Haslo"/><br/>
            <input type="submit" value="Zaloguj" name="button"/>
        </form>
        <form method="post" action="CreateUserServlet">
            <input type="submit" value="Zarejestruj sie" name="input5"/>
        </form>
    </div>
</body>
</html>
