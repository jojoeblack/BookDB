<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="model.Book" %>
<% Book book = (Book) request.getAttribute("book") ;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=big5">
<title>Sci Fi Library - Update a Book</title>
</head>
<body align="center">
<form name=updateForm action=updateBook method=get  align="center">
	<label hidden>
	Book ID:
	</label>
	<input type=text name=bookID value="<%= book.getBookID() %>"  hidden/>
	<br/>
	
	<label>
	Book Title:
	</label>
	<input type=text name=title value="<%= book.getTitle() %>"/>
	<br/>	
	
	<label>	
	Book Author:
	</label>
	<input type=text name=author value="<%= book.getAuthor() %>"/>
	<br/>
	
	<label>
	Book Pages:
	</label>
	<input type=text name=pages value="<%= book.getPages() %>"/>
	<br/>
	
	<input type=submit name=submit value="Update the Book"/>
</form>
</body>
</html>