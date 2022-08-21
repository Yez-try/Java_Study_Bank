<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글 작성</h1>
<hr>
<form action="./add.mg" method = "post">
	 제  목 <input type="text" placeholder="제목 입력" name="title"><br>
	작성자 <input type="text" value=${sessionScope.member.id } readonly="readonly" name="id">
	<hr>
	내용 입력 <br>
	<textarea rows="10" cols="100"   name ="contents"></textarea>
	<br>
	<button type ="submit">작성완료</button>
</form>
</body>
</html>