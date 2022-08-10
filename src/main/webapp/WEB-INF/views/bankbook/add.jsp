<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 상품 등록 폼</h1>
	<hr>
	<form action="./add" method="post"><!-- action역할 체크 -->
		상품이름 <input type="text" name="bookname"><br>
		이자율 <input type="text" name="bookrate"><br>
		<button type="submit" value="create">상품등록</button>
	</form>
</body>
</html>