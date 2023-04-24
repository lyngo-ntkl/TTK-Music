<%-- 
    Document   : admisnistration
    Created on : Apr 17, 2023, 9:23:47 AM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--c:if test="${sessionScope.USER == null || sessionScope.USER.role ne 'ADMIN'}">
            <c:redirect url="login.jsp"/>
        </c:if--%>
        <h1>Hello World!</h1>
    </body>
</html>
