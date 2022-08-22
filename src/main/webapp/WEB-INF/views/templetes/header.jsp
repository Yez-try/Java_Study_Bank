<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

    <header class="container-fluid px-0">
    <!-- Semantic태그 : nav와 같이 의미가 있는 태그 -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/bankbook/list.mg">상품리스트</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/board/list.mg">공지사항</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/member/search.mg">회원검색</a>
                </li>

                
                <c:choose>
                	<c:when test="${not empty member}">
                <li class="nav-item">
                    <a class="nav-link" href="/member/myPage.mg">마이페이지</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/member/Logout.mg">로그아웃</a>
                	</c:when>
                	<c:otherwise>
                <li class="nav-item">
                    <a class="nav-link" href="/member/login.mg">로그인</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/member/join.mg">회원가입</a>
                </li>
                </c:otherwise>
                </c:choose>
              </ul>
            </div>
          </div>
    </nav>
    
    
    </header>