<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 15.03.2018
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<h1>Update Student</h1>
<form:form action="/update/${student.id}" method="post" modelAttribute="student">
    <table border="1">
        <tr>
            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="external">External:</form:label></td>
            <td><form:checkbox path="external"></form:checkbox></td>
        </tr>
        <tr>
            <td><form:label path="createDate"></form:label></td>
            <td><form:input path="createDate" disabled="true"></form:input></td>
        </tr>
    </table>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
