<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 26.04.2018
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List students</title>
</head>
<body>
<h1>
    List students
</h1>

<table border="1">
    <tr>
        <th>name</th>
        <th>age</th>
        <th>regDate</th>
        <th>is admin</th>
        <th colspan="3">actions</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td><fmt:formatDate value="${student.regDate}" pattern="MM.dd.yyyy"></fmt:formatDate></td>
            <td>${student.admin}</td>
            <td><a href="updateStudent/${student.id}">Update</a></td>
            <td><a href="deleteStudent/${student.id}">Delete</a></td>
            <td><a href="listBooks/${student.id}">List students</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="addStudent">Add student</a></td>
    </tr>
</table>

</body>
</html>
