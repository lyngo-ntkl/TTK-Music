<%-- 
    Document   : register
    Created on : Apr 10, 2023, 9:56:37 AM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TTK Music - Sign up</title>
    </head>
    <body>
        <form method="post" action="MainController">
            <label>Username</label>
            <input name="username" type="username"/>
            <label>Email</label>
            <input name="email" type="email"/>
            <label>Password</label>
            <input name="password" type="password"/>
            <label>Re-enter password</label>
            <input name="check-password" type="password"/>
            <input type="submit" value="Sign up"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
