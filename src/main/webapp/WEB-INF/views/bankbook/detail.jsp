<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<a href = "../member/login.mg">Login</a> <!-- 경로를 주는 행위 -->
	<!-- 절대경로 -->
	<a href = "/member/join.mg">Join</a>
	<br>
<%--	//EL을 사용하면 아래 스크립틀릿 코드가 필요없어진다. Request scope
			<% AccountListDTO acDTO = (AccountListDTO) request.getAttribute("detail");

			if(acDTO != null){%>
 --%>
	<table border = "1"><%-- border를 안써주면 테이블 테두리가 나타나지 않는다. --%>
		<thead> 
		<tr>
			<th>Num</th><th>Name</th><th>Rate</th><!-- <th>Sale</th>  -->
		</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.detail.getBooknum()}</td><!-- EL은 자동형변환을 해주므로 우리가 형변환해줄 필요가 없다 -->
				<td>${requestScope.detail.bookname}</td><!-- getter의 get을 지우고 첫글자를 소문자로 바꾸고()를 삭제하고 사용해도 된다.(멤버변수처럼) -->
				<td>${detail.bookrate}</td><!-- requestScope를 생략하고 멤버변수처럼 사용해도 작동한다. -->
<%--			<td><%= acDTO.getBooknum()%></td>
				<td><%= acDTO.getBookname()%></td>
				<td><%= acDTO.getBookrate()%></td>
				<td><% if(acDTO.getBooksale()==1){%>
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
	<hr>
	<a href="./list.mg">리스트 보기</a>
 	<a href="./update.mg?booknum=${detail.booknum}">수정</a>
 	<a href="./delete.mg?booknum=${detail.booknum}">삭제</a>
	<c:if test = "${not empty sessionScope.member }">
	<a href="../bankAccount/add.mg?booknum=${detail.booknum}">가입하기</a>
	</c:if>
</body>
</html>