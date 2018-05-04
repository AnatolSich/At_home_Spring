<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Add book</title>
</head>
<body>
<h1>Add book</h1>
<form:form action="/addBook" method="post">
    <input type="text" name="title"/>
    <input type="text" name="author"/>
    <input type="text" name="pages"/>
    <input type="text" name="student" value="${studentId}"/>
    <input type="submit" value="Add book"/>
</form:form>
</body>
</html>
