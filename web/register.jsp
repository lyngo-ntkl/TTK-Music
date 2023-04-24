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
        <script src="js/PasswordValidation.js"></script>
        <title>TTK Music - Sign up</title>
    </head>
    <body>
        <form method="post" action="MainController">
            <label>Email</label>
            <input name="email" type="email" required=""/>
            <br>
            <label>Password</label>
            <input id="password1" name="password" type="password" required="" oninput="validatePasswordFormat(this,'passwordInform')"/>
            <br>
            <div id="passwordInform"></div>
            <label>Confirm password</label>
            <input id="password2" name="confirmPassword" type="password" required="" oninput="checkPasswordMatching()"/>
            <div id="confirmInform"></div>
            <br>
            <label>Username</label>
            <input name="username" type="text" required=""/>
            <br>
            <input name="action" type="submit" value="Sign up"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
