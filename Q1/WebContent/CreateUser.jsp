<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
</head>
<body>
	<form action = "AddUserServlet" method = "post">
		Enter the firstName : <input type = "text" id="firstName" name = "firstName">
		Enter the firstName : <input type = "text" id="lastName" name = "lastName">
		Enter the age :
		<select name = "age"> 
		<%for(int i=1;i<=100;i++) {%>
			<option id = <%=i %>><%=i %></option>
		<%} %>
		</select>
		<input type = "Submit" value = "Add User">
	</form>
</body>
</html>