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
	<% int count = 0; %>
	<table border='1'>
		<%
			for (int i = 0; i < 3; i++) {
				out.print("<tr>");
				for (int j = 0; j < 4; j++) {
					out.print("<td>");
					out.print("테이블" + ++count);
					out.print("</td>");
				}
				out.println("</tr>");
			}
		%>
	</table>
	<br>
	<%
		count = 0;
	%>
	<table border='1'>
		<% for (int i = 0; i < 3; i++) { %>
		<tr>
			<% for (int j = 0; j < 4; j++) { %>
			<td>테이블<%=++count%></td>
			<% } %>
		</tr>
		<% } %>
	</table>
</body>
</html>