<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	@import url('https://fonts.googleapis.com/css?family=Sunflower:300&display=swap');
	h1, h2 {font-family: 'Sunflower', sans-serif;}
</style>
</head>
<body>
<%!
	String greeting = "쇼핑몰 접속을 환영합니다.";
	String tagline = "장터 환영합니다.";
%>
<h1><%= greeting %></h1>
<h2><%= tagline %></h2>
<h3><%= new java.util.Date() %></h3>
<%
	java.util.Date mydate = new java.util.Date();
	out.print("<h4>" + mydate + "</h4>");
%>

</body>
</html>