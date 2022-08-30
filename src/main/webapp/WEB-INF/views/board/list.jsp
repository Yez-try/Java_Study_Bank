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
<form action="./list.mg" method = "get" class ="">
	<div class= "col-12">
	<label class="visually-hidden" for ="kind">pre</label>
	<select name="kind" class="form-select" id="kind">
		<option class="kinds" value="contents">Contents</option>
		<option class="kinds" value="title">title</option>
		<option class="kinds" value="writer">writer</option>
	</select>
	
	</div>
 	<div class="col-12">
       <label class="visually-hidden" for="search">검색어</label>
       <div class="input-group">
       	<!-- 파라미터 값을 꺼내서 써보자 -->
         <input type="text" name="search" value="${param.search}" class="form-control" id="search" placeholder="SEARCH">
       </div>
     </div>
   
    <div class="col-12">
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form>
</div>
</div>


<div class="container">
	<div class="row gx-2">
		<div class="col-7">
			<p class="h1 fw-bold mb-4 mx-1 mx-md-4 mt-5">${board}List</p>
		</div>
		<div class="col-3">
			<div class="input-group mb-4 mx-2 mx-md-5 mt-5">
			  <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">전체</button>
			  <ul class="dropdown-menu">
			    <li><a class="dropdown-item" href="#">제목</a></li>
			    <li><a class="dropdown-item" href="#">내용</a></li>
			    <li><a class="dropdown-item" href="#">작성자</a></li>
			    <li><hr class="dropdown-divider"></li>
			    <li><a class="dropdown-item" href="#">전체</a></li>
			  </ul>
			  <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
			  <button class="btn btn-outline-secondary" type="button" id="button-addon2">Button</button>
			</div>
		</div>
		<div class="col-2">
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
					<td>
					<c:catch>
					<c:forEach begin="1" end="${dto.depth}">ㅡ</c:forEach>
					</c:catch>
					<a href = "./detail.mg?num=${pageScope.dto.num}">${dto.title }</a></td>
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
			    <!-- choose사용해서 해보기 -->
			    <c:choose>
			    	<c:when test="${pager.pre}">
				<li class="page-item disabled">
			    	</c:when>
			    	<c:otherwise>
			    <li class="page-item">
			    	</c:otherwise>
			    </c:choose>
			      <a class="page-link" href="./list.mg?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">이전</span>
			      </a>
			    </li>
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    <li class="page-item"><a class="page-link" href="./list.mg?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			    </c:forEach>
			    <!-- 삼항연산자 사용해서 해보기 -->
			    <li class="${pager.next? 'page-item disabled':'page-item'}">
			      <a class="page-link" href="./list.mg?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">다음</span>
			      </a>
			    </li>
			    <li class="page-item">
			      <a class="page-link" href="./list.mg?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&raquo;&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
	</div>
</div>






<div class="container">
	<c:import url="../templetes/footer.jsp"></c:import>
</div>
<script src="/resources/js/board.js"></script>
<script>
	const kinds = document.getElementsByClassName("kinds")
	let k = '${param.kind}'//title, writer, contents 등의 값이 들어갈 수 있음
	for(let i=0; i<kinds.length;i++){
		if(kinds[i].value == k){
			kinds[i].selected = true
			break;
		}
	}
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>