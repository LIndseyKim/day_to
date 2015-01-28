<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="user_modify.do"> 
	<table>
		<tr>
			<th>아이디</th>
			<td>${requestScope.user.userId }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name = "password"/></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name = "name" value="${requestScope.user.name }"/>	</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name = "email" value="${requestScope.user.email }"/> </td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정"/> 
				<input type="reset" value="취소"/> 
			</td>
		</tr>	
	</table>
		<input type="hidden" name="userId" value="${user.userId }"> 
		<!-- 사용자 입력아니지만 hidden 쓰면 값으로 전달됌 -->
	</form>
</body>
</html>