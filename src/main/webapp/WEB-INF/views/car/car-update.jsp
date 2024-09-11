<%@page import="com.remind.test.vo.CarVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>차량수정</h3>
<%
CarVO car = (CarVO)request.getAttribute("car");
%>
<form method="POST" action="/car/car-update">
	<input type ="hidden" name ="ciNum" value="<%=car.getCiNum()%>">
	<input type="text" name="ciName" placeholder="모델명" value="<%=car.getCiName()%>"><br>
	<input type="text" name="ciYear"  placeholder="년식" value="<%=car.getCiYear()%>"><br>
	<button>수정</button>
</form>
</body>
</html>