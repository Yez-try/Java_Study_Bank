<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//스크립틀릿 <% java code작성 % >
    	//HTML에 있는 표현식 <% = 자바변수 또는 값 % > 표현식은 세미콜론을 쓰지 않는다.
    	//이제는 이걸 안쓴다.
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
			<c:forEach begin="0" end="10" var="i" step="2"> <!-- 여기서 i는 페이지스코프라고 한다.-->
			<!-- 밑에서부터 위로올라가는건 안된다.step="-1"불가 -->
				<h3>${pageScope.i}</h3> <!-- 페이지객체 i는 page변수내에 소속되어 있는데 jsp가 실행될 때 만들어졌다가 jsp가 종료되면 삭제된다.   -->
			</c:forEach>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td><a href="detail.mg?booknum=${dto.booknum}">${dto.bookname }</a></td>
					<td>${dto.bookrate }</td>
				</tr>
			</c:forEach>
			<%-- <% for(BankBookDTO bankbookDTO:ar){ %>
			<tr>
				<td><a href = "detail?booknum=<%=bankbookDTO.getBooknum()%>"> <%= bankbookDTO.getBookname() %></a></td>
				<td><%= bankbookDTO.getBookrate() %></td>
			</tr>			
			<% } %>
			--%>
		</tbody>
	</table>
	<a href="./add.mg">상품등록</a>

</body>
</html>