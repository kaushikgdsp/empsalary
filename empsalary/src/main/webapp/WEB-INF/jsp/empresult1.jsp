<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>

<header><p align="center" style="color: brown; font-size: 1.5cm">Employee Details</p></header>
<br>
<table style="background-color: grey" align="center" width="75%">
 <thead>
   <tr style="background-color: black; color: white">
     <th>Employee code</th>
     <th>Employee name</th>
     <th>Employee monthly salary</th>
     <th>Calculated bonus amount</th>
   </tr>
 </thead>
 <tbody>         
  <c:forEach var="e" items="${emp}">
   <tr style="color: blue">
     <td>${e.code}</td>
     <td>${e.name}</td>
     <td>${e.salary}</td>
     <td>${e.bonus}</td>
   </tr>
  </c:forEach>
</tbody>
</table>
<br><br>
<a href="/empsalary/empinsertform">Back</a>
<br><br>
<a href="/empsalary">Home</a>

</body>
</html>