<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {border-collapse : collapse;}
</style>
</head>
<body>
	<table border='1'>
	<%
		for (int i = 0; i < 9; i++) {
			out.print("<tr>");
			for (int j = 0; j < 9; j++) {
				out.print("<td>");
				out.print((j+1)+"*"+(i+1)+"="+((i+1)*(j+1)));
				out.print("</td>");
			}
			out.print("</tr>");
		}
	%>
	</table>
</body>
</html>