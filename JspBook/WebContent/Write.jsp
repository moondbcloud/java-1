<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 글쓰기</h1>
	<form method='post' action='./WriteOk.jsp'>
	<table border='1'>
		<tr>
			<td width='100'>제목</td>
			<td width='400'><input type='text' name='b_subject' size='40'></td>
		</tr>
		<tr>
			<td width='100'>이름</td>
			<td width='400'><input type='text' name='b_name'></td>
		</tr>
		<tr>
			<td width='100'>통신사</td>
			<td width='400'>
				<input type='radio' name='phone' value='SKT' checked>SKT&nbsp;  
				<input type='radio' name='phone' value='KT'>KT&nbsp;&nbsp;
				<input type='radio' name='phone' value='LGT'>LGT&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td width='100'>지역</td>
			<td width='400'>
				<select name='area'>
					<option value='충북' selected>충북</option>
					<option value='경기'>경기</option>
					<option value='서울'>서울</option>
				</select>
			</td>
		</tr>
		<tr>
			<td width='100'>내용</td>
			<td width='400'><textarea rows='15' cols='40' name='b_contents'></textarea></td>
		</tr>
		<tr>
			<td colspan='2'><input type='submit'></td>
		</tr>
	</table>
	</form>
</body>
</html>