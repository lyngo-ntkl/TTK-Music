<%-- 
    Document   : userpage
    Created on : Apr 12, 2023, 7:15:43 AM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TTK Music - Sound - Light and Music Education</title>
    </head>
    <body>
        <c:if test="${sessionScope.USER == null || sessionScope.USER.role ne 'USER'}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <h1>Hello ${sessionScope.USER.username}</h1>
    </body>
</html>
