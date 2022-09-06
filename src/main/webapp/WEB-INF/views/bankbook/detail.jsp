<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../templetes/header.jsp"></c:import>
	<h1> Bankbook detail</h1>
	<hr>
	<!-- 상대경로 -->
	<a href = "../member/login.mg">Login</a> <!-- 경로를 주는 행위 -->
	<!-- 절대경로 -->
	<a href = "/member/join.mg">Join</a>
	<br>
<%--	//EL을 사용하면 아래 스크립틀릿 코드가 필요없어진다. Request scope
			<% AccountListDTO acDTO = (AccountListDTO) request.getAttribute("detail");

			if(acDTO != null){%>
 --%>
	<table border = "1"><%-- border를 안써주면 테이블 테두리가 나타나지 않는다. --%>
		<thead> 
		<tr>
			<th>Num</th><th>Name</th><th>Rate</th><!-- <th>Sale</th>  -->
		</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.detail.getBooknum()}</td><!-- EL은 자동형변환을 해주므로 우리가 형변환해줄 필요가 없다 -->
				<td>${requestScope.detail.bookname}</td><!-- getter의 get을 지우고 첫글자를 소문자로 바꾸고()를 삭제하고 사용해도 된다.(멤버변수처럼) -->
				<td>${detail.bookrate}</td><!-- requestScope를 생략하고 멤버변수처럼 사용해도 작동한다. -->

			</tr>
		</tbody>
	</table>

	<hr>
	<!--Comment 영역-->
	<div class="row">
		<!--form으로 보내면 동기방식, 페이지를 보내버리므로 지금은 form 태그나 name태그가 필요없다-->
			<div class="mb-3">
				<label for="writer" class="form-label">UserID</label>
				<input type="test" class="form-control" id="writer" placeholder="id">
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">Write contents</label>
				<textarea class="form-control" id="contents" rows="3"></textarea>
			</div>
			<div class="mb-3">
				<button type="button" id="commentbtn" data-booknum="${detail.booknum}">댓글작성</button>
			</div>
	</div>
	<!--Comment 끝-->
	<!--comment list 출력-->
	<div id="commentList">
		
	</div>
	<!--Comment list 끝-->


	<a href="./list.mg">리스트 보기</a>
 	<a href="./update.mg?booknum=${detail.booknum}">수정</a>
 	<a href="./delete.mg?booknum=${detail.booknum}">삭제</a>
	<c:if test = "${not empty sessionScope.member }">
	<a href="../bankAccount/add.mg?booknum=${detail.booknum}">가입하기</a>
	</c:if>
	<script src="/resources/js/bankbookComment.js"></script>
</body>
</html>