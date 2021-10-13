<%-- 
    Document   : home
    Created on : 12-Oct-2021, 8:46:04 PM
    Author     : wenchi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h2>Hello ${username}</h2>
        <form action="login" method="get">
            <input type="submit" name="logout" value="logout">
        </form>
    </body>
</html>
