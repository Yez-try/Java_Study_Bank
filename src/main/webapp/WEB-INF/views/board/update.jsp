<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 수정 페이지</h1>
	<hr>
	<form action="./update.mg" method="post">
	글제목 <br> 
	<textarea rows="1" cols="100" name ="title">${board.title }</textarea>
	<br>
	글내용<br>
	<textarea rows="10" cols="100" name ="contents">${board.contents }</textarea>
	<br>
	<input type="hidden" value=${board.no } name="no">
	<button type="submit">수정하기</button>
	</form>
</body>
</html>