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
	<h1>Login Page</h1>
	<hr>
    <!-- HTML이 루트폴더가 됨 -->
    <!-- 	//id,pw를 입력해도 같은 로그인 페이지로 요청이 올텐데 어떻게 구분하지?
			//Get방식으로 주면 : 로그인 가입 양식을 보려고 하는구나!
			//Post 방식으로 주면 : 입력한 정보로 로그인 판단 -->
    <div>
    	<!-- <form action="study/member/login" method="post"></form> -->
    	<form action="./login.mg" method="post">
        ID  <input type = "text" name = "id" ><br> <!-- 입력한 input태그의 값이 value로 넘어가는데 구분이 어려워서 name속성이 구분해주는 이름(key)임 -->
        PW  <input type = "password" name = "pw"> <br>
        <input type = "submit">
        아이디 기억하기 <input type = "checkbox" name = "holdId">
        </form>
        
        
    	<img src = "/resources/img/발레하는유리.jpg">
    </div>
</body>
</html>