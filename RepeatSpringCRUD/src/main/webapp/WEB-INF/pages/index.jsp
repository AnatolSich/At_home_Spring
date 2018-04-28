<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 15.03.2018
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<h1>Students</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>External</th>
        <th>Create Date</th>
        <th colspan="2">Operation</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.name} </td>
            <td>${student.external}</td>
            <td>${student.createDate}</td>
            <td><a href="/update/${student.id}">Update</a></td>
            <td><a href="/delete/${student.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/addStudent">Add student</a>
</body>
</html>
