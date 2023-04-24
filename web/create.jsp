<%-- 
    Document   : create
    Created on : Apr 18, 2023, 11:19:28 PM
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
        <h1>Course information</h1>
        <form action="MainController" method="POST" enctype="multipart/form-data">
            <label for="courseName">Name</label>
            <input name="courseName" type="text"/>
            <br>
            <label for="image">Image</label>
            <input name="image" type="file" accept="image/png, image/jpeg"/>
            <br>
            <label for="description">Description</label>
            <input name="description" type="text"/>
            <br>
            <label for="tuitionFee">Tuition fee</label>
            <input name="tuitionFee" type="number" step="0.01"/>
            <br>
            <label for="category">Category</label>
            <select name="category">
                <option value="1">Instruments</option>
                <option value="2">Music production</option>
                <option value="3">Music fundamentals</option>
                <option value="4">Vocal</option>
                <option value="5">Music techniques</option>
                <option value="6">Music software</option>
                <option value="7">Others</option>
            </select>
            <br>
            <label for="quantity">Quantity</label>
            <input name="quantity" type="number"/>
            <br>
            <label for="startedDate">Started Date</label>
            <input name="startedDate" type="date"/>
            <br>
            <label for="endedDate">Ended Date</label>
            <input name="endedDate" type="date"/>
            <br>
            <input name="createdUser" type="hidden" value="${sessionScope.USER.id}"/>
            <button type="submit" name="action" value="Create course">Create</button>
        </form>
    </body>
</html>
