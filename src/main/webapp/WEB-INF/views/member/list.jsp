<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page import="com.iu.start.bankMembers.BankMembersDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>멤버 리스트</h1>
	<form action="./search" method="post">
		아이디 <input type="text" name="search">
		<input type="submit"> 
	</form>
	<hr>
			<c:forEach begin="0" end="10" var="i" step="2"> <!-- 여기서 i는 페이지스코프라고 한다.-->
			<!-- 밑에서부터 위로올라가는건 안된다.step="-1"불가 -->
				<h3>${pageScope.i}</h3> <!-- 페이지객체 i는 page변수내에 소속되어 있는데 jsp가 실행될 때 만들어졌다가 jsp가 종료되면 삭제된다.   -->
			</c:forEach>
	<table border="1">
		<thead>
		<tr><th>id</th><th>name</th><th>email</th><th>phone</th><th>lv</th></tr>
		</thead>
		<tbody>
		<c:forEach items="${requestScope.mlist}" var ="dto">
			<tr>
				<td>${pageScope.dto.id}</td><td>${dto.name}</td><td>${dto.email}</td><td>${dto.phone}</td><td>${dto.lv}</td>
			</tr>
		</c:forEach>
		<%--<%ArrayList<BankMembersDTO> arr = (ArrayList<BankMembersDTO>)request.getAttribute("mlist"); 
		for(BankMembersDTO dto : arr){
		%>
		<tr>
		<td><%=dto.getId() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getEmail() %></td>
		<td><%=dto.getPhone() %></td>
		<td><%=dto.getLv() %></td>
		</tr>
		<%} %>
		--%>
		</tbody>
	</table>
</body>
</html>