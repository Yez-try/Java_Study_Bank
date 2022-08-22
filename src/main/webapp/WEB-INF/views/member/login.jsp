<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
    <div>
    <c:import url="../templetes/header.jsp"></c:import>
    
    </div>
	<h1>Login Page</h1>
	<hr>
    <!-- HTML이 루트폴더가 됨 -->
    <!-- 	//id,pw를 입력해도 같은 로그인 페이지로 요청이 올텐데 어떻게 구분하지?
			//Get방식으로 주면 : 로그인 가입 양식을 보려고 하는구나!
			//Post 방식으로 주면 : 입력한 정보로 로그인 판단 -->
    <div>
    	<!-- <form action="study/member/login" method="post"></form> -->
    	<form action="./login.mg" method="post">
			<section class="container-fluid mt-5 text-center">
				<div class="row justify-content-md-center">
					<div class="mb-3 col-1">
					  <label class="form-label">ID</label>
					</div>
					<div class="mb-3 col-2">
					  <input type="text" class="form-control" name="id" placeholder="아이디 입력">
					</div>
				</div>
				<div class="row justify-content-md-center">
					<div class="col-1">		
					  <label for="exampleFormControlInput1" class="form-label">Password</label>
					</div>
					<div class="col-2">
					  <input type="password" class="form-control" name="pw" placeholder="비밀번호 입력">
					</div>
				</div>
						<div class="container mt-3">
						<button type="submit" class="btn btn-outline-dark" >로그인</button>
						</div>
			</section>
			</form>
    	<c:import url="../templetes/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    	
</body>
</html>