<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Toll
  Date: 24.02.2018
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="addStudent">
    <table border="1">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value=""/></td>
        </tr>
        <tr>
            <td>Extramural</td>
            <td><input type="checkbox" name="isExtramural"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add student"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
