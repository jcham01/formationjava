<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/<%= request.getAttribute("style") %>" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>triangle</title>
</head>
<body>
<h2 id="titrePage" >triangle de taille <%= request.getAttribute("dimension") %></h2>

<table>
<%
int dimension = (int) request.getAttribute("dimension");
for (int ligne = 0; ligne < dimension; ligne++) {
%>
<tr>
	<% for (int colonne = 0; colonne < dimension - ligne; colonne++) {%>
		<td class='<%= (ligne == 0 || colonne == 0 || colonne == dimension - ligne - 1)? "bord" : "centre" %>'>
		<%= (ligne == 0 || colonne == 0 || colonne == dimension - ligne - 1)? '*' : ' ' %>
		</td>
	<% } %>
</tr>
<%
}
%>
</table>


<a href="index.html">retour au formulaire</a>
</body>
</html>