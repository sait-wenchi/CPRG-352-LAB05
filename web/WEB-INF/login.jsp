<%-- 
    Document   : login
    Created on : 12-Oct-2021, 8:45:52 PM
    Author     : wenchi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            Username: <input type="text" name="username" value="" /> <br>
            Password: <input type="text" name="password" value="" /> <br>
            <input type="submit" value="Log in">
        </form>
        <p>${message}</p>
    </body>
</html>
