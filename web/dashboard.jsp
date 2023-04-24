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
        <%--c:if test="${sessionScope.USER == null || sessionScope.USER.role ne 'USER'}">
            <c:redirect url="login.jsp"/>
        </c:if--%>
        <header>
            <form action="MainController" method="POST">
                <input name="searchKey" type="text" value="${param.searchKey}"/>
                <button name="action" type="submit" value="Search">Search</button>
            </form>
            <ul>
                <li><a href="create.jsp">Create course</a></li>
                <li>Update course</li>

                <li><a href="MainController?action=Logout">Logout</a></li>
            </ul>
        </header>
        <h1>Hello ${sessionScope.USER.username}</h1>
        <c:choose>
            <c:when test="${requestScope.COURSES != null && not empty requestScope.COURSES}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Image</th>
                            <th>Course name</th>
                            <th>Description</th>
                            <th>Tuition fee</th>
                            <th>Category</th>
                            <th>Created date</th>
                            <th>Started date</th>
                            <th>Ended date</th>
                            <th>Last updated date</th>
                            <th>Last updated user</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="course" items="${requestScope.COURSES}" varStatus="i">
                            <tr>
                                <td>${i.count}</td>
                                <td><img src="${course.image}" alt="${course.courseName}"/></td>
                                <td>${course.description}</td>
                                <td>${course.tuitionFee}</td>
                                <td>${course.categoryId}</td>
                                <td>${course.createdDate}</td>
                                <td>${course.startedDate}</td>
                                <td>${course.endedDate}</td>
                                <td>${course.lastUpdatedDate}</td>
                                <td>${course.lastUpdatedUserId}</td>
                                <td>${course.quantity}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="">
                    
                </c:if>
            </c:when>
            <c:when test="${param.searchKey != null && not empty param.searchKey}">
                No courses found
            </c:when>
        </c:choose>
    </body>
</html>
