<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<title>${board} list</title>
</head>
<body>
<div>
	<c:import url="../templetes/header.jsp"></c:import>
</div>


<div class="container">
	<div class="row gx-2">
		<div class="col-10">
			<p class="h1 fw-bold mb-4 mx-1 mx-md-4 mt-5">${board}List</p>
		</div>
		<div class="col ">
			<div class="mb-4 mx-2 mx-md-5 mt-5">
				<c:if test="${not empty sessionScope.member}">
		        	<a href="add.mg" role="button" class="btn btn-dark btn-small">글 작성</a>
				</c:if>
	        </div>
			
		</div>
		<table class="table table-bordered table-sm table-hover ">
			<thead class="table-dark table-gradient">
				<tr>
				<th>글번호</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto"><!-- BoardDTO인데  noticeDTO를 꺼내옴 -->
				<tr>
					<td>${pageScope.dto.num}</td>
					<td><a href = "./detail.mg?num=${pageScope.dto.num}">${dto.title }</a></td>
					<td>${dto.writer }</td>
					<td>${dto.hit }</td>
					<td>${dto.regDate }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
			<nav aria-label="Page navigation">
			  <ul class="pagination justify-content-center">
			  	<li class="page-item">
			      <a class="page-link" href="./list.mg?page=1" aria-label="Previous">
			        <span aria-hidden="true">&laquo;&laquo;</span>
			      </a>
			    </li>
			    <li class="page-item">
			      <a class="page-link" href="./list.mg?page=${pager.startNum-1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    <li class="page-item"><a class="page-link" href="./list.mg?page=${i}">${i}</a></li>
			    </c:forEach>
			    <li class="page-item">
			      <a class="page-link" href="./list.mg?page=${pager.lastNum+1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			    <li class="page-item">
			      <a class="page-link" href="./list.mg?page=${pager.totalPage}" aria-label="Next">
			        <span aria-hidden="true">&raquo;&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
	</div>
</div>






<div>
	<c:import url="../templetes/footer.jsp"></c:import>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>