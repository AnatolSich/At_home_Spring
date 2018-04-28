<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 26.04.2018
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List books</title>
</head>
<body>
<h1>List books</h1>

<table border="1">
    <tr>
        <th>title</th>
        <th>author</th>
        <th>pages</th>
        <th>student</th>
        <th colspan="2">actions</th>
    </tr>

    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.pages}</td>
            <td>${book.student.id}</td>
            <td><a href="updateBook/${book.id}">Update book</a> </td>
            <td><a href="deleteBook/${book.id}">Delete book</a> </td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="addBook/${studentId}">Add book</a> </td>
    </tr>
</table>
</body>
</html>
