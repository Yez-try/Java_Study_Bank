<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
    <hr>
    <a href = "study_index.html"> 인덱스 페이지 </a>
    <div>
    	<form action="./join" method="post">
	        아이디 <input type = "text" name = "id"><br>
	        이름 <input type="text" name = "name"><br>
	        비밀번호 <input type = "password" name = "pw"><br>
	        이메일 <input type = "email" name = "email"><br>
	        전화번호 <input type = "tel" name = "phone"><br>
	        관리자코드 <input type = "text" name = "lv"><br>
	        
	        <input type = "submit">
        </form>
        <form method = "post">
        	테스트 <input type="text" name = "test">
	   </form> 
    </div>
</body>
</html>