<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>liste des articles</title>
</head>
<body>
<h2>liste des articles</h2>
<table border="1">
<tr><th>libelle</th><th>prix</th><th>actions</th></tr>
<c:forEach items="${requestScope.articles}" var="a" >
<tr>
<td><c:out value="${a.libelle}" /></td>
<td><c:out value="${a.prix}" /></td>
<td>actions...</td>
</tr>
</c:forEach>
</table>
</body>
</html>