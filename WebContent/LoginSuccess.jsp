<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
</head>

<body>
<%
	//allow access only if session exists
	String user = (String) session.getAttribute("user");
	Integer userId = (Integer)session.getAttribute("userId");
	String nome = (String) session.getAttribute("nome");
	String cognome = (String) session.getAttribute("cognome");
	Integer societaId = (Integer) session.getAttribute("societa_id");
	String societa = (String) session.getAttribute("societa");
	Integer tessera = (Integer) session.getAttribute("tessera");

	String userName = null;
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user"))
				userName = cookie.getValue();
			if (cookie.getName().equals("JSESSIONID"))
				sessionID = cookie.getValue();
		}
	}
%>
<h3>Ciao <%=nome %>, Login corretto. La tua Session ID=<%=sessionID%> società=<%=societa%> </h3>

<br>
User=<%=user %>
<br>
<a href="CheckoutPage.jsp">Checkout Page</a>
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>
