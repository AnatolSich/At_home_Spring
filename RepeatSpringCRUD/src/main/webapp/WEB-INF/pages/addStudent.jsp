<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Add Student</title>
</head>
<h1>Add Student</h1>
<body>
<form:form action="/addStudent" method="post">
 <table border="1">
     <tr>
         <td>Name</td>
         <td><input type="text" name="name"/></td>
     </tr>
     <tr>
         <td>External</td>
         <td><input type="checkbox" name="external"/></td>
     </tr>
 </table>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
