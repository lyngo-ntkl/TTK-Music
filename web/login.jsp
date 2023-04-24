<%-- 
    Document   : login
    Created on : Apr 12, 2023, 8:24:43 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TTK Music - Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="MainController" method="POST">
            <label>Email</label>
            <input name="email" type="email" required=""/>
            <br>
            <label>Password</label>
            <input name="password" type="password" required=""/>
            <br>
            <input name="rememberMe" type="checkbox"/>
            <label for="rememberMe">Remember Me</label>
            <br>
            <button name="action" type="submit" value="Login">Login</button>
        </form>
    <c:if test="${requestScope.WARNING != null || not empty requestScope.WARNING}">
        ${requestScope.WARNING}
    </c:if>
    </body>
</html>
