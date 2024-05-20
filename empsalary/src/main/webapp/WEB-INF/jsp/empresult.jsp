<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
  
   <tr style="color: blue">
     <td>${emp.code}</td>
     <td>${emp.name}</td>
     <td>${emp.salary}</td>
     <td>${emp.bonus}</td>
   </tr>

</tbody>
</table>
<br><br>
<a href="/empsalary/empinsertform">Back</a>
<br><br>
<a href="/empsalary">Home</a>
</body>
</html>