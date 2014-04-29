<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<security:authentication property="authorities" var="authorities" />
	<ul>
		<c:forEach items="${authorities}" var="authority">
			<li>${authority.authority}</li>
		</c:forEach>
	</ul>
	<c:forEach begin="0" end="9" var="i" step="1">
		${i }&nbsp;
	</c:forEach>
	<c:choose>
		<c:when test="true">
			true
		</c:when>
		<c:otherwise>
			false
		</c:otherwise>
	</c:choose>
</body>
</html>