<%@page import="Q2.entity.BookEntity"%>
<%@page import="java.util.List"%>
<html>
<head>
	<title>Book Details</title>
</head>
<body>
<h1>Book Details</h1>
	<%List<BookEntity> list = (List<BookEntity>) request.getAttribute("bookList"); %>
	<form action = "removeBook" method = "post">
		<select name = "removeBook">
			<% for(BookEntity entity : list){%>
				<option value = <%=entity.getId()%>><%=entity.getBookName() %></option>
			<%} %>
			<input type = "Submit" value = "Delete">
		</select>
	</form>
</body>
</html>