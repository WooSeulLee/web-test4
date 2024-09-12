<%@page import="java.util.List"%>
<%@page import="com.remind.test.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저리스트</h3>

<button onclick="location.href='/views/user/user-insert'">유저 등록</button>

<table border ="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
	</tr>
<%
	List<UserVO> users = (List<UserVO>)request.getAttribute("users");
	for(UserVO user : users){
%>
	<tr>
		<td><%=user.getUiNum()%></td>
		<td><a href ="/user/user-view?uiNum=<%=user.getUiNum()%>"><%=user.getUiName()%></a></td>
	</tr>


<%
}
%>
</table>
</body>
</html>