<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
	<c:import url="../templetes/header.jsp"></c:import>
	
	
	<section class="container-fluid mt-5 text-center">
	<h1>마이페이지</h1>
	<hr>
	<div class="row gx-3">
		<div class="col-2">
			<img alt="#" src="/resources/img/blank-profile-picture.png">
		</div>
	</div>
	
	아이디 : ${dto.id}<br>
	이름 : ${dto.name}<br>
	이메일 : ${dto.email }<br>
	전화번호 : ${dto.phone}<br>
	
	</section>

	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">상품명</th>
	      <th scope="col">계좌번호</th>
	      <th scope="col">가입일</th>
	    </tr>
	  </thead>
	  <tbody>
		<c:forEach items="${list}" var="account">
			<tr>
			<td>${account.bankBookDTO.bookname }</td>
			<td>${account.acnum }</td>
			<td>${account.acdate }</td>
			</tr>
		</c:forEach>
	  </tbody>
	</table>
	

	<c:import url="../templetes/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>