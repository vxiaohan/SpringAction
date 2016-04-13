<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
	<c:if test="${!empty error }">
		<font color><c:out value="${error }" /></font>
	</c:if>
	<form action="<c:url value="/loginCheck.html" />" method="post">
		用户名：
		<input type="text" name="userName">
		密码：
		<input type="password" name="password">
		<br>
		<input type="submit" value="Login"/>
		<input type="reset" value="Reset"/>
	</form>
</body>
</html>