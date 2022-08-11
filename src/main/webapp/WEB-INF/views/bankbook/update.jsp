<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Bankbook update 페이지 </h1>
	<hr>
	<form action="" method="post">
		<input type="text" name="booknum" readonly="readonly" value=${dto.booknum }> 
		<!-- <input type="hidden" name="boooknum" value=${dto.booknum }> -->
		<div>
			Name : <input type="text" name="bookname" value=${dto.bookname }><!-- name에는 setter의 이름을 소문자로 변경해 써준다. -->
		</div>
		<div>
			Rate : <input type="text" name="bookrate" value=${dto.bookrate }>
		</div>
		
		<button type="submit">수정</button>
	</form>
</body>
</html>