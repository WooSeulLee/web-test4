<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품 등록 페이지</h3>
	<form method="POST" action="/goods/goods-insert">
		<table>
			<tr>
			<th>상품명</th>
			<td><input type="text" name="giName" placeholder="상품명"></td>
			</tr>
			
			<tr>
			<th>가격</th>
			<td><input type="text" name="giPrice" placeholder="가격"></td>
			</tr>
			
			<tr>
			<th>상품설명</th>
			<td><input type="text" name="giDesc" placeholder="상품 설명"></td>
			</tr>
		</table>
		<br>
		<button>상품 등록</button>
	</form>
</body>
</html>