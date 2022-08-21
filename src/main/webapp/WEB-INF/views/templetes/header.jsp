<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark bg-gradient">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Bank</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-between" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="/">Home</a>
        <a class="nav-link" href="./bankbook/list.mg">상품리스트</a>
        <a class="nav-link" href="./board/list.mg">게시판</a>
      </div>
      <div class="navbar-nav">
      	<c:choose>
      		<c:when test="${empty sessionScope.member}">
		        <a class="nav-link active" aria-current="page" href="./member/login.mg">로그인</a>
		        <a class="nav-link" href="./member/join.mg">회원가입</a>
        	</c:when>
        	<c:otherwise>
        		<a class="nav-link" href="./member/logout.mg">로그아웃</a>
        		<a class="nav-link active" aria-current="page" href="#">My page</a>
        	</c:otherwise>
        </c:choose>
      </div>
    </div>
  </div>
</nav>
</body>
</html>