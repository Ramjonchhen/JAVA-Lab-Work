<%! String username,password; %>

<%
	username = request.getParameter("username");
	password = request.getParameter("password");
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Secure Admin WebApp</title>
</head>
<body>
	<%
		if (username.equals("admin") && password.equals("admin") ) {
	%>
		<h1> Welcome <%=username%> to the JSP Admin Webpage</h1>
		<form action="Qno9LogoutPage.jsp" method="POST">
			<input type="submit" value="Logout">
		</form>
	<%} else { %>
		 <h1>Wrong Credentials Please Try Again!!!</h1>
	<%} %>
</body>
</html>