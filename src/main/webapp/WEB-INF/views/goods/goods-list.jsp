<%@page import="java.util.List"%>
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
<h3>상품 리스트</h3>

<table border ="1">
	
	<tr>
		<th>번호</th>
		<th>상품명</th>
		<th>가격</th>
	</tr>
	
<%
	List<GoodsVO> goodsList = (List<GoodsVO>)request.getAttribute("goodsList");
	for(GoodsVO goods : goodsList){
%>

	<tr>
		<td><%=goods.getGiNum() %></td>
		<td><a href="/goods/goods-view?giNum=<%=goods.getGiNum()%>"><%=goods.getGiName()%></a></td>
		<td><%=goods.getGiPrice() %></td>
	</tr>
	
<%
	}
%>
</table>
<br>
<button onclick="location.href='/views/goods/goods-insert'">상품 등록하러 가기</button>

</body>
</html>