<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");	//폼에서 넘어오는 데이터의 한글처리
		String b_subject = request.getParameter("b_subject");
		String b_name = request.getParameter("b_name");
		String b_contents = request.getParameter("b_contents");
		
		Connection conn = null;	//데이터베이스 연결 객체 선언(아직 메모리에 없음)
		Statement stmt = null;	//SQL 문장 처리 객체 선언(아직 메모리에 없음)
		ResultSet rs = null;		//조회된 테이블 결과 저장 객체(select 실행시 필요, 그 외는 불필요)
		String sql = "";	//쿼리작성용 문자열
		
		Calendar cal = Calendar.getInstance();
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1;
		int dd = cal.get(Calendar.DAY_OF_MONTH);
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		int ms = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
		String b_date = String.format("%02d-%02d-%02d %02d:%02d:%02d",yy,mm,dd,hh,ms,ss);
		
		try {
			Class.forName("org.sqlite.JDBC");	//JDBC  드라이버 로드
			out.print("드라이버로드OK<br>");
			conn = DriverManager.getConnection("jdbc:sqlite:D:\\sqlite3\\mydb.db");
			out.print("디비연결OK<br>");
			stmt = conn.createStatement();	//쿼리실행용 객체 생성
			
			sql = "insert into board (b_subject,b_name,b_visit,b_date,b_contents) ";
			sql += "values ('" + b_subject + "','";
			sql += b_name + "',0,'";
			sql += b_date + "','";
			sql += b_contents + "')";
			
			stmt.executeUpdate(sql);
			response.sendRedirect("./List.jsp"); 	//디비에 쓰기 작업 후 리스트 페이지로 이동
			//out.print(sql + "<br>");
			//out.print("쿼리실행OK<br>");
		} catch (Exception e) {
			out.print(e.toString() + "DB 에러");
		}
		try {
			stmt.close();	//객체 닫기
			conn.close();	//객체 닫기
		} catch (Exception e) {
			out.print(e.toString() + "DB닫기 에러");
		}
		
	%>
</body>
</html>