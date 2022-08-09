<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!-- 아래코드가 한글 안깨져 보이게 하는 코드 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="./member/login">로그인</a><br>
<a href="member/join">회원가입</a>
<hr>

<a href="./bankbook/list">상품리스트</a>
<a href="./bankbook/detail">상품찾기</a>
<a href="./bankbook/add">상품등록</a>

</body>
</html>
