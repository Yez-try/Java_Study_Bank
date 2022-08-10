<%@page import="com.iu.start.bankMembers.BankMembersDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<table border="1">
		<thead>
		<tr><th>id</th><th>name</th><th>email</th><th>phone</th><th>lv</th></tr>
		</thead>
		<tbody>
		<%ArrayList<BankMembersDTO> arr = (ArrayList<BankMembersDTO>)request.getAttribute("mlist"); 
		for(BankMembersDTO dto : arr){
		%>
		<tr>
		<td><%=dto.getId() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getEmail() %></td>
		<td><%=dto.getPhone() %></td>
		<td><%=dto.getLv() %></td>
		<%} %>
		</tbody>
	</table>
</body>
</html>