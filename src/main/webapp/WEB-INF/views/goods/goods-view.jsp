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
<h3>상품 정보</h3>
<%
	GoodsVO goods = (GoodsVO)request.getAttribute("goods");
%>
<form method ="POST" action="/goods/goods-delete">
	<input type ="hidden" name ="giNum" id="giNum" value="<%=goods.getGiNum()%>">
	<table border="1">
		<tr>
			<th>번호</th>
			<td><%=goods.getGiNum()%></td>
		</tr>
		<tr>
			<th>상품명</th>
			<td><%=goods.getGiName()%></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><%=goods.getGiPrice()%></td>
		</tr>
		<tr>
			<th>상품설명</th>
			<td><%=goods.getGiDesc()%></td>
		</tr>
		<tr>
			<th>등록날짜</th>
			<td><%=goods.getCredat()%></td>
		</tr>
		<tr>
			<td><button type="button" onclick="location.href='/goods/goods-update?giNum=<%=goods.getGiNum()%>'">상품 수정하러 가기</button></td>
			<td><button>상품 삭제하러 가기</button></td>
		</tr>
	</table>
	<br>
	<br>
	<a href="/goods/goods-list">상품 리스트로 돌아가기</a>
</form>
</body>
</html>