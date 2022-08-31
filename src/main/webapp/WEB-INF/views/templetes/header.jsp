<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

    <header class="container-fluid px-0">
    <!-- Semantic태그 : nav와 같이 의미가 있는 태그 -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark bg-gradient">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="/">Bank</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse justify-content-between" id="navbarNavAltMarkup">
	      <div class="navbar-nav">
	        <a class="nav-link active" aria-current="page" href="/">Home</a>
	        <a class="nav-link" href="/bankbook/list.mg">상품리스트</a>
	        <a class="nav-link" href="/notice/list.mg">공지사항</a>
	        <a class="nav-link" href="/qna/list.mg">QnA</a>
	      </div>
	      <div class="navbar-nav">
	      	<c:choose>
	      		<c:when test="${empty sessionScope.member}">
			        <a class="nav-link active" aria-current="page" href="/member/login.mg">로그인</a>
			        <a class="nav-link" href="/member/joinAgre.mg">회원가입</a>
	        	</c:when>
	        	<c:otherwise>
	        		<a class="nav-link" href="/member/logout.mg">로그아웃</a>
	        		<a class="nav-link active" aria-current="page" href="/member/myPage.mg">My page</a>
	        	</c:otherwise>
	        </c:choose>
	      </div>
	    </div>
	  </div>
	</nav>
    
    
    </header>