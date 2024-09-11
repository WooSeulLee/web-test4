<%@page import="com.remind.test.vo.CarVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>차량목록</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>model</th>
			<th>년식</th>
		</tr>
<%
List<CarVO> cars = (List<CarVO>) request.getAttribute("cars");
for (CarVO car : cars) {
%>

		<tr>
			<th><%=car.getCiNum()%></th>
			<th><%=car.getCiName()%></th>
			<th><%=car.getCiYear()%></th>
		</tr>
<%
}
%>
	</table>
</body>
</html>