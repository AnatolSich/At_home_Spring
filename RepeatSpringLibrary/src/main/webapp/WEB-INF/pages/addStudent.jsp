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
    <title>Add student</title>
</head>
<body>
<h1>Add student</h1>
<form:form action="/addStudent" method="post">
    <input type="text" name="name"/>
    <input type="text" name="age"/>
    <input type="checkbox" name="isAdmin"/>
    <input type="submit" value="Add student"/>
</form:form>

</body>
</html>
