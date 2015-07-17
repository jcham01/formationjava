<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edition Article</title>
</head>
<body>
<h2>edition Article</h2>
<p>
<c:out value="${requestScope.article.libelle}" />
</p>
<form action="ArticleServlet" method="post">
<input type="hidden" name="id" value='<c:out value="${requestScope.article.id}" />'>
<input type="hidden" name="action" value='sauver'>
nom: <input type="text" name="libelle" value='<c:out value="${requestScope.article.libelle}" />'><br />
email: <input type="text" name="prix" value='<c:out value="${requestScope.article.prix}" />'><br />
solde: <input type="text" name="poids" value='<c:out value="${requestScope.article.poids}" />'><br />
<input type="submit" value="sauver" />
</form>
</body>
</html>