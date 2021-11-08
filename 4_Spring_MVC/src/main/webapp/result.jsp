<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login form submit Result</title>
<link href="css/index.css" rel="stylesheet">
</head>
<body>

<table id=resultTable>
	<tr>
		<td>Login: </td>
		<td><%=request.getParameter("login") %> </td>
	</tr>
	<tr>
		<td>Password: </td>
		<td><%=request.getParameter("password") %> </td>
	</tr>
	<tr>
		<td>Full name</td>
		<td><%=request.getParameter("fullname") %> </td>
	</tr>
	<tr>
		<td>Phone</td>				
		<td><%=request.getAttribute("phone") %></td>
	</tr>
	<tr>
		<td>Gender</td>
		<td><%=request.getAttribute("gender") %></td>
	</tr>
	<tr>
		<td>Hobbies</td>
		<td><%=request.getAttribute("hobbies") %></td>
	</tr>
	<tr>
		<td>Favorite color</td>
		<td><div style="width:20px;height:20px;border:1px solid #000;background-color: <%=request.getParameter("favcolor") %>"></div></td>
	</tr>
	</table>
</body>
</html>