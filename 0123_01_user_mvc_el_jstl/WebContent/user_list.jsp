<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<img src="${pageContext.request.contextPath}/Images/penguin5.png"/>
<img src="../Images/penguin5.png"/>
<table style="border:1px solid blue">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
	</tr>
	<c:choose>
		<c:when test="${not empty requestScope.userList}">
<%-- 		<c:when test="${userList!=null && userList.size()>0}"> --%>
			<c:forEach items="${userList}" var="user" varStatus="status"> 
				<tr>
					<td> ${pageScope.status.count}</td>
					<td> ${user.userId} </td>
					<td> <a href="${pageContext.request.contextPath}/user_edit.do?userId=${user.userId }">${user.name }</a></td>
					<td> ${user.email} 	</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
				<tr>
				<td colspan="3"> 등록된 사용자가 없슴다.</td>
				</tr>	
		</c:otherwise>
	</c:choose>
	</table>
</body>
</html>