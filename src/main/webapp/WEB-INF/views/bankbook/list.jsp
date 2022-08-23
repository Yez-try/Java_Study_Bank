<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> BankBook List</h1>
	<!-- /bankbook/list -->
	<!-- 인덱스 페이지에 a 태그로 저 주소를 만들어서 클릭하면 여기로 올 수 있도록 -->
	
	<!-- /bankbook/detail jsp:detail.jsp -->
	<!-- link주소는 상대경로로 작성해주세요. -->
	<hr>
	<table border = "1">
		<thead>
			<th>Name</th><th>Rate</th>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td><a href="detail.mg?booknum=${dto.booknum}">${dto.bookname }</a></td>
					<td>${dto.bookrate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./add.mg">상품등록</a>

</body>
</html>