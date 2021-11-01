<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login form submit Result</title>
<link href="<%= request.getContextPath() %>/css/index.css" rel="stylesheet">
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
		<% 
		String code = "";
		
		int codeid = Integer.parseInt(request.getParameter("code"));
		
			 switch(codeid) {
	         case 0:
	        	 code = "+38";
	        	break;
	         case 1:
	        	 code = "+7";
	            break;
	         case 2:
	        	 code = "+375";
	            break;
	         case 3:
	        	 code = "+373";
	            break;
	         default:
	        	 code = "+38";
	      }	
		%>
		<td><%=code%><%=request.getParameter("phone")%></td>
	</tr>
	<tr>
		<td>Gender</td>
		<td><%=request.getParameter("gender") %> </td>
	</tr>
	<tr>
		<td>Hobbies</td>
		<td>
		<%
			StringBuilder selectedHobbies = new StringBuilder();
			String[] hobbiesList=request.getParameterValues("hobbies");
			String separator = "";
			for (String hobby : hobbiesList) {
			    if (hobby != null) {
			    	selectedHobbies.append(separator);
					System.out.println(hobby);

			    	selectedHobbies.append(hobby);			    	
			    	separator = ", ";
			    }
		    } 
		%>
		<%=selectedHobbies.toString()%>
		</td>
	</tr>
	</table>
</body>
</html>