<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/Images/penguin5.png"/>
<img src="Images/penguin5.png"/>
<br/>
누적 방문자 수 : <fmt:formatNumber type="number" value="1000000"
								pattern="###,###"/> 명<br/>
<c:choose>
	<c:when test="${userId != null }">
	<h2>${sessionScope.userId}로그인 중</h2>
	<ul>
<!-- 		<li><a href="user_list.do">목록 조회</a></li> -->
<%-- 		<li><a href="http://127.0.0.1:9090${pageContext.request.contextPath}/controller/user_list.do">목록 조회</a></li> --%>
		<li><a href="controller/user_list.do">목록 조회</a></li>
		<li><a href="Logout.do">로그아웃</a></li>
	</ul>
	</c:when>
	<c:otherwise>
<%-- 	<%@ include file="login.jsp" %>--%>
<jsp:include page="login.jsp"></jsp:include>
	</c:otherwise>
</c:choose>
</body>
</html>