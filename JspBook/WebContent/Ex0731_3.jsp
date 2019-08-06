<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!
		public int sum(int a, int b) {
			return a+b;
		}
	%>
	<%
		out.print("두 수의 합은 " + sum(2, 3) + "<br>");
	%>
</body>
</html>