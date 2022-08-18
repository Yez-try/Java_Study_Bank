<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div>
        <ul>
            <li><a href="/bankbook/list.mg">상품리스트</a></li>
            <li><a href="/board/list.mg">게시판</a></li>
            <li><a href="/member/login.mg">로그인</a></li>
            <li><a href="/member/join.mg">회원가입</a></li>
        </ul>
    
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
        ID  <input type = "text" name = "id" ><br> <!-- 입력한 input태그의 값이 value로 넘어가는데 구분이 어려워서 name속성이 구분해주는 이름(key)임 -->
        PW  <input type = "password" name = "pw"> <br>
        <input type = "submit">
        아이디 기억하기 <input type = "checkbox" name = "holdId">
        </form>
        
        <iframe width="560" height="315" src="https://www.youtube.com/embed/w7aQE69x2kQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    	<img src = "/resources/img/귀여운유리.png">
    </div>
</body>
</html>