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
	UserVO user = (UserVO) request.getAttribute("user");
	%>
	<form method="POST" action="/user/user-insert">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="uiName"></td>
			</tr>

			<tr>
				<th>아이디</th>
				<td><input type="text" name="uiId"></td>
			</tr>

			<tr>
				<th>생년월일</th>
				<td><input type="date" name="uiBirth"></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="uiPwd"></td>
			</tr>

			<tr>
				<th>성별</th>
				<td>남<input type="radio" name="uiGender" value="1"> 여<input
					type="radio" name="uiGender" value="2">
				</td>
			</tr>

			<tr>
				<th>취미</th>
				<td>자전거<input type="checkbox" name="uiHobby" value="자전거">
					영화<input type="checkbox" name="uiHobby" value="영화"> 드라이브<input
					type="checkbox" name="uiHobby" value="드라이브"> 여행<input
					type="checkbox" name="uiHobby" value="여행">
				</td>
			</tr>

			<tr>
				<th>소개</th>
				<td><textarea name="uiDesc"></textarea></td>
			</tr>

			<tr>
				<th colspan="2">
					<button>등록</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>