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
<%--	//EL을 사용하면 아래 스크립틀릿 코드가 필요없어진다. Request scope
			<% AccountListDTO acDTO = (AccountListDTO) request.getAttribute("detail");
			if(acDTO != null){%>
 --%>
	<table border = "1">
		<thead> 
		<%-- border를 안써주면 테이블 테두리가 나타나지 않는다. --%>
		<tr>
			<th>Num</th><th>Name</th><th>Rate</th><!-- <th>Sale</th>  -->
		</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.detail.getAcId()}</td><!-- EL은 자동형변환을 해주므로 우리가 형변환해줄 필요가 없다 -->
				<td>${requestScope.detail.acName}</td><!-- getter의 get을 지우고 첫글자를 소문자로 바꾸고()를 삭제하고 사용해도 된다.(멤버변수처럼) -->
				<td>${detail.acRate}</td><!-- requestScope를 생략하고 멤버변수처럼 사용해도 작동한다. -->
<%--			<td><%= acDTO.getAcId()%></td>
				<td><%= acDTO.getAcName()%></td>
				<td><%= acDTO.getAcRate()%></td>
 				<td><% if(acDTO.getAcSale()==1){%>
					판매중
					<%} else{ %>
					판매금지
					<%} %></td>
 --%>
			</tr>
		</tbody>
	</table>
<%--			<%}else{%>
			<h3> 찾는상품이 없습니다. </h3>
			<%} %>
 --%>
 	<a href="./update?acId=${detail.acId}">수정</a>
</body>
</html>