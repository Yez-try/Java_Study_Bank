<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board.title }</h1>
	작성자 : ${board.id } 작성일 : ${board.bdate } 조회수 : ${board.views }
	<c:if test="${board.id eq sessionScope.member.id }">
	<a href="./update.mg?no=${board.no}">글 수정</a>
	<a href="./delete.mg?no=${board.no}">글 삭제</a>
	</c:if>
	<hr>
	${board.contents}
</body>
</html>