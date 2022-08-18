<!-- jstl을 쓰겠다 라고 선언하는 코드.  <c하면 나오는 문번들은 jstl언어이다 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 아래코드가 한글 안깨져 보이게 하는 코드 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/test.css">
	<style><!-- 인터널방식 -->
		li{
			color:green;
		}
	</style>

</head>
<body>
<h2>h2를 분홍색으로</h2>
<!-- 순서가 있는 리스트-->
<ol> <!-- 앞에 숫자가 나옴 -->
	<li style="color:red;">first</li> <!-- 인라인방식 -->
	<li>Second</li>
	<li>third</li>
</ol>

<!-- 순서가 없는 리스트 -->
<ul> <!-- 앞에 동그라미가 나옴 -->
	<li>first</li>
	<li>Second</li>
	<li>third</li>
</ul>

<!-- nav -->



<!-- Group -->
<div>
	<ul>
		<li><a href="/bankbook/list.mg">상품리스트</a></li>
		<li><a href="/board/list.mg">게시판</a></li>
		<li><a href="/member/login.mg">로그인</a></li>
		<li><a href="/member/join.mg">회원가입</a></li>
	</ul>

</div>

<img src="/resources/img/발레하는유리.jpg" >
<!-- alt속성은 웹접근성 관련한 내용으로 여기에 이미지가 있음을 알려줌/ 디자이너가 함 -->



<h1>
	Hello world!  
</h1>
<h3>
	Add VSCODE
</h3>
<h3>Add Spring</h3>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${empty sessionScope.member}">
<!-- 로그인이 안됐으면 이게 나오고 -->
<a href="./member/login.mg">로그인</a><br>
<a href="member/join.mg">회원가입</a>
</c:if>
<!-- 로그인이 됐으면 이게 나온다 ifelse문이 없으므로 단일if문으로 써준다-->
<c:if test="${not empty sessionScope.member }">
<h3>${sessionScope.member.name}님 환영합니다.</h3>
<a href ="./member/logout.mg">Logout</a>
<a href ="#">My page</a>
</c:if>
<hr>
<a href="./bankbook/list.mg">상품리스트</a>
<a href="./bankbook/add.mg">상품등록</a>

<hr>

<a href="./member/search.mg">아이디검색</a>

</body>
</html>
