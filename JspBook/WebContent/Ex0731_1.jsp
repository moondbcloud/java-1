<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%! //int count = 0; %>
<body>
<%
	for (int i = 0; i < 5; i++) {
		out.print("<h1>JSP Test</h1>");
	}
%>
<h2>JSP Test 2</h2>
<h2>JSP Test 2</h2>
<h2>JSP Test 2</h2>
<h2>JSP Test 2</h2>
<h2>JSP Test 2</h2>
<%
	//out.println(++count);
	out.print(myMethod(0));

	out.println("<h3>JSP</h3>");
%>
<%!
	public int myMethod(int count) {
		return ++count;	
	}
%>
</body>
</html>