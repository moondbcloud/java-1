<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag - UseBean</title>
</head>
<body>
	<jsp:useBean id="person" class="dao.Person" scope="request" />
	<p>아이디 : <%=person.getId() %></p>
	<p>이   름 : <%=person.getName() %></p>
</body>
</html>