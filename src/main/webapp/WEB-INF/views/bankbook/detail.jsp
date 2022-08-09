<%@page import="com.iu.start.accountList.AccountListDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Bankbook detail</h1>
	<hr>
	<!-- 상대경로 -->
	<a href = "../member/login">Login</a> <!-- 경로를 주는 행위 -->
	<!-- 절대경로 -->
	<a href = "/member/join">Join</a>
	<br>
			<% AccountListDTO acDTO = (AccountListDTO) request.getAttribute("detail");
			if(acDTO != null){%>
	<table border = "1">
		<thead> 
		<%-- border를 안써주면 테이블 테두리가 나타나지 않는다. --%>
		<tr>
			<th>Num</th><th>Name</th><th>Rate</th><th>Sale</th>
		</tr>
		</thead>
		<tbody>
			<tr>
				<td><%= acDTO.getAcId()%></td>
				<td><%= acDTO.getAcName()%></td>
				<td><%= acDTO.getAcRate()%></td>
				<td><% if(acDTO.getAcSale()==1){%>
					판매중
					<%} else{ %>
					판매금지
					<%} %></td>
			</tr>
		</tbody>
	</table>
			<%}else{%>
			<h3> 찾는상품이 없습니다. </h3>
			<%} %>
</body>
</html>