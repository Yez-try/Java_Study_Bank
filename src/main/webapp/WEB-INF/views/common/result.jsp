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
<h1>common result 페이지</h1>

<script type="text/javascript">

	let message = '${message}';
	alert(message);
	location.href="${url}";
</script>

</body>
</html>