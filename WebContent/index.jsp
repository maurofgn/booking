<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina iniziale</title>
</head>
<body>
	pagina iniziale
	<center>
		<h2>HTTP Header Request</h2>
		<table width="100%" border="1" align="center">
			<tr bgcolor="#949494">
				<th>Header Name</th>
				<th>Header Value(s)</th>
			</tr>
			<%
				Enumeration<String> headerNames = request.getHeaderNames();
				while (headerNames.hasMoreElements()) {
					String paramName = headerNames.nextElement();
					String paramValue = request.getHeader(paramName);
					out.println("<tr><td>" + paramName + "</td><td> " + paramValue + "</td></tr>\n");
				}
			%>
		</table>
	</center>

</body>
</html>