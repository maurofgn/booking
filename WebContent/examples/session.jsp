<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sessione</title>
</head>
<body>

<%

	String invalida = request.getParameter("invalidate");
	if (invalida != null && !invalida.isEmpty())
		session.invalidate();
	else {


	   // Get session creation time.
	   Date createTime = new Date(session.getCreationTime());
	   // Get last access time of this web page.
	   Date lastAccessTime = new Date(session.getLastAccessedTime());
	
	   String title = "Welcome Back to my website";
	   Integer visitCount = new Integer(0);
	   String visitCountKey = new String("visitCount");
	   String userIDKey = new String("userID");
	   String userID = new String("ABCD");
	
	   // Check if this is new comer on your web page.
	   if (session.isNew()){
	      title = "Welcome to my website";
	      session.setAttribute(userIDKey, userID);
	      session.setAttribute(visitCountKey,  visitCount);
	   }
	   visitCount = (Integer)session.getAttribute(visitCountKey);
	   if (visitCount == null)
		   visitCount = 1;
	   else
		   visitCount = visitCount + 1;
	   session.setAttribute(visitCountKey,  visitCount);
	
	   userID = (String)session.getAttribute(userIDKey);
	   if (userID == null)
		   userID = new String("ABCD");
	%>
	
	<center>
	<h1>Session Tracking</h1>
	</center>
	<table border="1" align="center"> 
	<tr bgcolor="#949494">
	   <th>Session info</th>
	   <th>Value</th>
	</tr> 
	<tr>
	   <td>id</td>
	   <td><% out.print( session.getId()); %></td>
	</tr> 
	<tr>
	   <td>Creation Time</td>
	   <td><% out.print(createTime); %></td>
	</tr> 
	<tr>
	   <td>Time of Last Access</td>
	   <td><% out.print(lastAccessTime); %></td>
	</tr> 
	<tr>
	   <td>User ID</td>
	   <td><% out.print(userID); %></td>
	</tr> 
	<tr>
	   <td>Number of visits</td>
	   <td><% out.print(visitCount); %></td>
	</tr> 
	</table> 
<% }%>

</body>
</html>