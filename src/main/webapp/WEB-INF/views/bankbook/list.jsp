<%@page import="com.iu.start.accountList.AccountListDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//스크립틀릿 <% java code작성 % >
    	//HTML에 있는 표현식 <% = 자바변수 또는 값 % > 표현식은 세미콜론을 쓰지 않는다.
    	//이제는 이걸 안쓴다.
    	ArrayList<AccountListDTO> ar = (ArrayList<AccountListDTO>)request.getAttribute("list");
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
	<a href = "./detail">BankBook Detail</a>
	<hr>
	<table border = "1">
		<thead>
			<th>Name</th><th>Rate</th>
		</thead>
		<tbody>
			<% for(AccountListDTO bankbookDTO:ar){ %>
			<tr>
				<td><a href = "detail?booknum=<%=bankbookDTO.getAcId()%>"> <%= bankbookDTO.getAcName() %></a></td><td><%= bankbookDTO.getAcRate() %></td>
			</tr>			
			<% } %>
		</tbody>
	</table>
	
</body>
</html>