
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bienvenue sur loncoto</title>
</head>
<body>
<h2>nous sommes le <%= new Date() %></h2>

<form action="Home" method="post">
votre nom: <input type="text" name="nom" id="nom" /><br />
votre mdp: <input type="password" name="motdepasse" id="motdepasse" /><br />
<input type="submit" value="se connecter" /> <br />
</form>

<hr />
<ul>
<% for (int i = 1; i < 10; i++) { %>
	<li>choix <%= i %></li>
<% } %>
</ul>
<ol>
<% for (int j = 1; j < 10; j++ ){
	out.println("<li>" + j + "</li>");
}	
%>	
</ol>

</body>
</html>