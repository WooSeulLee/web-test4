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
<h3>유저 정보 수정</h3>
<%
	UserVO user = (UserVO)request.getAttribute("user");
%>
<form method="POST" action="/user/user-update">
<input type ="hidden" name ="uiNum" value="<%=user.getUiNum()%>">
<table border="1">
	<tr>
		<th>번호</th>
		<td><%=user.getUiNum()%></td>
	</tr>
	
	<tr>
		<th>이름</th>
		<td><input type="text" name="uiName" value="<%=user.getUiName()%>"></td>
	</tr>
	
	<tr>
		<th>아이디</th>
		<td><%=user.getUiId()%></td>
	</tr>
	
	<tr>
		<th>비밀번호</th>
		<td><input type="text" name="uiPwd" value="<%=user.getUiPwd()%>"></td>
	</tr>
	
	<tr>
		<th>생년월일</th>
		<td><input type="date" name="uiBirth" value="<%=user.getUiId()%>"></td>
	</tr>
	
	<tr>
		<th>성별</th>
		<td>
			남<input type="radio" name="uiGender" value="1" <%="1".equals(user.getUiGender())?"checked":""%>>
			여<input type="radio" name="uiGender" value="2" <%="2".equals(user.getUiGender())?"checked":""%>>
		</td>
	</tr>
	
	<tr>
		<th>취미</th>
		<td>
			자전거<input type="checkbox" name="uiHobby" value="자전거"
			<%=user.getUiGender() !=null && user.getUiHobby().indexOf("자전거")!=-1?"checked":""%>>
			영화<input type="checkbox" name="uiHobby" value="영화"
			<%=user.getUiGender() !=null && user.getUiHobby().indexOf("영화")!=-1?"checked":""%>>
			드라이브<input type="checkbox" name="uiHobby" value="드라이브"
			<%=user.getUiGender() !=null && user.getUiHobby().indexOf("드라이브")!=-1?"checked":""%>>
			여행<input type="checkbox" name="uiHobby" value="여행"
			<%=user.getUiGender() !=null && user.getUiHobby().indexOf("여행")!=-1?"checked":""%>>
		
		</td>
	</tr>
	
	<tr>
	<th>소개</th>
	<td><textarea name="uiDesc"><%=user.getUiDesc()%></textarea></td>
	</tr>
	
	<tr>
	<th colspan="2">
		<button>수정</button>
	</th>
	</tr>
</table>
</form>
</body>
</html>