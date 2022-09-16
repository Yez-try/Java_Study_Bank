<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<!-- summerNote -- jquery -->
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<title>${board} 글수정 페이지</title>
</head>
<body>
<c:import url="../templetes/header.jsp"></c:import>

<h1>글 수정 페이지</h1>
	<hr>
	<form action="./update.mg" method="post">
	글제목 <br> 
	<textarea rows="1" cols="100" name ="title" id="title">${boardDTO.title }</textarea>
	<br>
	글내용<br>
	<textarea rows="10" cols="100" name ="contents" id="contents">${boardDTO.contents }</textarea>
	<br>

	<div>
		
	</div>

	<input type="hidden" value=${boardDTO.num } name="num">
	<button type="submit">수정하기</button>
	</form>




<c:import url="../templetes/footer.jsp"></c:import>
<script type = "text/javascript">
	$("#contents").summernote()
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>