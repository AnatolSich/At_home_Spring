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
    <title>Update student</title>
</head>
<body>
<h1>Update student</h1>
<form:form action="/updateStudent/${student.id}" method="post">
    <input type="text" name="name" value="${student.name}"/>
    <input type="text" name="age" value="${student.age}"/>
    <input type="checkbox" name="isAdmin" />
    <input type="submit"  value="Update student"/>
</form:form>
</body>
</html>
