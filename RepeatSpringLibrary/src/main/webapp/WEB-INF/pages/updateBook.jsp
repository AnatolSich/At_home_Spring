<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 26.04.2018
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update book</title>
</head>
<body>
<h1>Update book</h1>
<form:form action="/updateBook/${book.id}" method="post">
    <input type="text" name="title" value="${book.title}"/>
    <input type="text" name="author" value="${book.author}"/>
    <input type="text" name="pages" value="${book.pages}"/>
    <input type="text" name="student" value="${book.student.id}"/>
    <input type="submit" value="Update book"/>
</form:form>
</body>
</html>
