<%@page import="com.grs.model.Movie"%>
<%@page import="jakarta.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Movie m = (Movie)session.getAttribute("movie");	
		out.println(m);
	%>

</body>
</html>