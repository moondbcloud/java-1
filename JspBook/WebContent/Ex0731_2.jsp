<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! int data = 50; %>
	<%
		out.println("data 변수의 값은 " + data + " 입니다." + "<br>");
		out.println("data 변수의 값은 " + data + " 입니다.<br>");
	%>
</body>
</html>