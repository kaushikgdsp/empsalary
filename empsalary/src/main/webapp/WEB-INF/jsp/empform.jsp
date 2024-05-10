<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee data insert</title>
</head>
<body>
<p align="center" style="color: brown; font-size: 1.5cm">Employee details</p>
<form:form action="/empadd" method="POST" modelAttribute="eform">
   
   <table style="color: green; font-size: 0.5cm">
   <tr align="left"><th><form:label path="code">*Employee code: </form:label></th> 
   <td><form:input type="number" path="code" /></td>
   <td><form:errors path="code" style="color: red" /></td></tr>
   
   <tr align="left"><th><form:label path="name">*Employee name: </form:label></th>
   <td><form:input type="text" path="name" /></td>
   <td><form:errors path="name" style="color: red" /></td></tr>
   
   <tr align="left"><th><form:label path="salary">*Employee monthly salary: </form:label></th>
   <td><form:input type="number" path="salary" /></td>
   <td><form:errors path="salary" style="color: red" /></td></tr>
   
   <tr align="right"><td colspan="2"><br><br><input type="submit" value="Save Details"/></td></tr>
   </table>
   
</form:form>
<br><br>* compulsory fields<br><br><br>
<a href="/">Home</a>
</body>
</html>