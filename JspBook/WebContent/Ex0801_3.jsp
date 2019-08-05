<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<%
		String subject = request.getParameter("subject");
		String uname = request.getParameter("uname");
		String contents = request.getParameter("contents");
		
		contents = contents.replace("'", " ");
		contents = contents.replace("<", "&lt;");
		contents = contents.replace(">", "&gt;");
		contents = contents.replace("\n", "<br>");
		
		String phone = request.getParameter("phone");
		String area = request.getParameter("area");
		out.print("제목 : " + subject + "<br>");
		out.print("이름은 " + uname + " 입니다.<br>");
		out.print("내용" + contents + "<br>");
		out.print("통신사 " + phone + "<br>");
		out.print("지역 " + area + "<br>");
		out.print("접속아이피 " + request.getRemoteAddr());
	%>
</body>
</html>