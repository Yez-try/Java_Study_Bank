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
	<h1>Board List</h1>
	<hr>
	<c:if test="${not empty sessionScope.member }">
	<a href="add.mg">글 작성하기</a>
	</c:if>
	<table border ="1">
	<thead>
		<tr>
			<th>NO</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="board">
		<tr>
			<td>${pageScope.board.no}</td>
			<td><a href = "./detail.mg?no=${pageScope.board.no}">${board.title }</a></td>
			<td>${board.id }</td>
			<td>${board.views }</td>
			<td>${board.bdate }</td>
	</c:forEach>
	</tbody>
	</table>

</body>
</html>