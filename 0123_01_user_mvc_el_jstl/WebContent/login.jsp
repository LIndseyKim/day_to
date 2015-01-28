<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashMap" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인정보를 입력하세요</h1>
<c:if test="${requestScope.message != null}">
	<h3 style="color:red">${requestScope.message}</h3>
</c:if>
<!-- <form method="post" action="login.do"> -->
<!-- <form method="post" action="http://127.0.0.1:9090/0123_01_user_mvc_el_jstl/login.do"> -->
<!-- <form method="post" action="/0123_01_user_mvc_el_jstl/login.do"> -->
<%-- <form method="post" action="<%=request.getContextPath() %>/login.do"> --%>
<form method="post" action="${pageContext.request.contextPath}/login.do">
	아이디:<input type="text" name="userId"/>
	<c:if test="${requestScope.fieldErrors.idError!=null }">
		<span style="color:red">${requestScope.fieldErrors.idError}</span>
	</c:if>
	<br/>
	비밀번호:<input type = "password" name="password"/>
	<c:if test="${requestScope.fieldErrors.pwError!=null }">
		<span style="color:red">${requestScope.fieldErrors.pwError}</span>
	</c:if>
	<br/>
	<input type="submit" value="전송"/>
	<input type="reset" value="취소"/>
</form>
</body>
</html>