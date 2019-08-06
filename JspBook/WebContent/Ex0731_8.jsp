<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i+1; j++) {
				out.print("*");
			}
			out.print("<br>");
		}
		out.println("<br>");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5-i; j++) {
				out.print("*");
			}
			out.print("<br>");
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				out.print("*");
			}
			out.print("<br>");
		}
	%>
</body>
</html>