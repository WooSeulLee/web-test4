<%@page import="com.remind.test.vo.GoodsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품 수정</h3>
<%
	GoodsVO goods = (GoodsVO)request.getAttribute("goods");
%>
<form method="POST" action="/goods/goods-update">
	<input type ="hidden" name ="giNum" value="<%=goods.getGiNum()%>">
	<table >
		<tr>
			<th>번호</th>
			<td><%=goods.getGiNum()%></td>
		</tr>
		<tr>
			<th>상품명</th>
			<td><input type="text" id="giName" name="giName" value="<%=goods.getGiName()%>"></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="text" id="giPrice" name="giPrice" value="<%=goods.getGiPrice()%>"></td>
		</tr>
		<tr>
			<th>상품설명</th>
			<td><input type="text" id="giDesc" name="giDesc" value="<%=goods.getGiDesc()%>"></td>
		</tr>
	</table>
	
	<br>
	<button>상품 수정하러 가기</button>
</form>
</body>
</html>