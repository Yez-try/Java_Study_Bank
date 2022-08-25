<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<title>${dto.title}</title>
</head>
<body>
	<c:import url="../templetes/header.jsp"></c:import>


	<h1>${dto.title }</h1>
	작성자 : ${dto.writer } 작성일 : ${dto.regDate } 조회수 : ${dto.hit }
	<c:if test="${dto.writer eq sessionScope.member.id }">
	<a href="./update.mg?num=${dto.num}">글 수정</a>
	<a href="./delete.mg?num=${dto.num}">글 삭제</a>
	</c:if>
	<c:if test="${not empty dto and board eq 'Q&A'}">
		<a href="./reply.mg?num=${dto.num}" class="btn btn-danger">답글 달기</a>
	</c:if>
	<hr>
	${dto.contents}




<c:import url="../templetes/footer.jsp"></c:import>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>