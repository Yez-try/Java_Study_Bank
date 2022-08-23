<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<title>notice list</title>
</head>
<body>
<div>
	<c:import url="../templetes/header.jsp"></c:import>
</div>

<div class="container">
	<div class="row">
		<table class="table table-bordered table-sm">
			<colgroup>
                <col width="*" />
                <col width="100" />
                <col width="30" />
                <col width="*" />
                <col width="10" />
            </colgroup>
			<thead class="thead-light">
				<tr>
				<th>글번호</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="notice">
				<tr>
					<td>${pageScope.notice.num}</td>
					<td><a href = "./detail.mg?no=${pageScope.notice.num}">${board.title }</a></td>
					<td>${notice.writer }</td>
					<td>${notice.hit }</td>
					<td>${notice.regDate }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>







<div>
<c:import url="../templetes/footer.jsp"></c:import>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>