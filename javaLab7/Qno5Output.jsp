<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! String firstName,lastName; %>

<% 
	firstName = request.getParameter("fname");
	lastName = request.getParameter("lname");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Output of the Student Details</title>
</head>
<body>
	<h2>Output of the student details</h2>
	<h3>Full Name of the student is: <%= firstName+" "+lastName %></h3>
</body>
</html>