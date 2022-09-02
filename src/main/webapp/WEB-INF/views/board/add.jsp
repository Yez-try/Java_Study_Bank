<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jquery -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- bootstrap -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<title>${board } 작성</title>

    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
<c:import url="../templetes/header.jsp"></c:import>

<h1>${board } 작성</h1>
<hr>
<form action="./add.mg" method = "post" enctype="multipart/form-data">
	제  목 <input type="text" placeholder="제목 입력" name="title"><br>
	작성자 <input type="text" value=${sessionScope.member.id } readonly="readonly" name="writer">
	<hr>
	<div>
	<input type="file" name="files" class="form-control" >
	<input type="file" name="files" class="form-control" >
	<input type="file" name="files" class="form-control" >
	</div>
	내용 입력 <br>
	<textarea rows="10" cols="100"   name ="contents" id="contents1"></textarea>
	<br>
	<button type ="submit">작성완료</button>
</form>





<!-- bootStrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script type = "text/javascript">
	$("#contents1").summernote()
</script>
</body>
</html>