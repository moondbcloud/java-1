<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {border-collapse : collapse;}
	td.htitle {
		background-color : yellow;
		text-align : center;
	}
</style>
</head>
<body>
	<%
		Connection conn = null;	//데이터베이스 연결 객체 선언(아직 메모리에 없음)
		Statement stmt = null;	//SQL 문장 처리 객체 선언(아직 메모리에 없음)
		ResultSet rs = null;		//조회된 테이블 결과 저장 객체(select 실행시 필요, 그 외는 불필요)
		String sql = "";	//쿼리작성용 문자열
		
		try {
			Class.forName("org.sqlite.JDBC");	//JDBC  드라이버 로드
			out.print("드라이버로드OK<br>");
			conn = DriverManager.getConnection("jdbc:sqlite:D:\\sqlite3\\mydb.db");
			out.print("디비연결OK<br>");
			stmt = conn.createStatement();	//쿼리실행용 객체 생성
			sql = "select * from board order by b_num desc";
			rs = stmt.executeQuery(sql);	//쿼리 실행해서 결과를 rs 변수에 반환받음, rs는 거대한 변수
		} catch (Exception e) {
			out.print(e.toString() + "DB 에러");
		}
	%>
	<h1>게시판 리스트</h1>
	<a href='./Write.jsp'>글쓰기</a><br>
	<table border='1'>
	<tr>
		<td class='htitle' width='80'>번호</td>
		<td class='htitle' width='300'>제목</td>
		<td class='htitle' width='100'>작성자</td>
		<td class='htitle' width='80'>조회수</td>
		<td class='htitle' width='150'>작성일</td>
		<td class='htitle' width='80'>삭제</td>
	</tr>
	<%
		while (rs.next()){
			int b_num = rs.getInt("b_num");	//테이블의 필드명을 매개변수로 사용
			String b_subject = rs.getString("b_subject");
			String b_name = rs.getString("b_name");
			int b_visit = rs.getInt("b_visit");
			String b_date = rs.getString("b_date");
			String b_contents = rs.getString("b_contents");
	%>
			<tr>
				<td align='center'><%=b_num%></td>
				<td>
					<a href='./View.jsp?b_num=<%=b_num%>'><%=b_subject%></a>
				</td>
				<td align='center'><%=b_name%></td>
				<td align='center'><%=b_visit%></td>
				<td align='center'><%=b_date%></td>
				<td align='center'>
					<a href='./Delete.jsp?b_num=<%=b_num%>'>삭제</a>
				</td>
			</tr>
	<%		
			//out.print(b_num +"==" + b_subject + "==" + b_name + "==" + b_visit + "==" +b_date + "==" + b_contents + "<br>");
		}
	%>

	</table>

<%
		try {
			rs.close();	//객체 닫기
			stmt.close();	//객체 닫기
			conn.close();	//객체 닫기
		} catch (Exception e) {
			out.print(e.toString() + "DB닫기 에러");
		}
	%>
</body>
</html>