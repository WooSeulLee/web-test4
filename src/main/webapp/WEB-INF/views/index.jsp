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
<%
UserVO user = (UserVO)session.getAttribute("user");
if(user==null){
%>
<a href="/user/login"> 로그인 </a>을 해주세요
<%
}else{
%>
<h3>${user.uiName}님, 안녕하세요.</h3>


<a href="/views/user/user-list">유저리스트</a>
<a href="/car/car-list">차량리스트</a>
<a href="/goods/goods-list">상품리스트</a>
<%
}
%>
</body>
</html>