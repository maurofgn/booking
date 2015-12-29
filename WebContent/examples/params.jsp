<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*" %>

<%

//Get session creation time.
Date createTime = new Date(session.getCreationTime());
// Get last access time of this web page.
Date lastAccessTime = new Date(session.getLastAccessedTime());

//prende i cookie e ne estrae i valori
	Cookie cookie = null;
	Cookie[] cookies = null;
	// Get an array of Cookies associated with this domain
	cookies = request.getCookies();
	if( cookies != null ){
	   out.println("<center><h2> Found Cookies Name and Value</h2></center><ul>");

	   for (int i = 0; i < cookies.length; i++){
	      cookie = cookies[i];
	      out.print("<li> Name : " + cookie.getName( ) + ",  ");
	      out.print("Value: " + cookie.getValue( )+" </li><br/>");
	      /* cookie.setMaxAge(0); per delete cookie */
	   }
	   out.println(" </ul>");
	}else{
	   out.println("<center><h2>No cookies founds</h2></center>");
	}

//crea i cookie	
	String fn = request.getParameter("first_name");
	if (fn != null) {
	   // Create cookies for first and last names.      
	   Cookie firstName = new Cookie("first_name", fn);
	   // Set expiry date after 24 Hrs for both the cookies.
	   firstName.setMaxAge(60*60*24);
	   
	   response.addCookie( firstName );
	}
	
	String ln = request.getParameter("last_name");
	if (ln != null) {
	   // Create cookies for first and last names.      
	   Cookie lastName = new Cookie("last_name", ln);
	   // Set expiry date after 24 Hrs for both the cookies.
	   lastName.setMaxAge(60*60*24);
	   response.addCookie( lastName );
	}

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Esempio parametri</title>
</head>
<body>
<center>
<h1>Using GET Method to Read Form Data</h1>
</center>
<ul> 
<li><p><b>First Name:</b> 
   <%= request.getParameter("first_name")%>
</p></li> 
<li><p><b>Last  Name:</b> 
   <%= request.getParameter("last_name")%>
</p></li> 
</ul> 


<form action="params.jsp" method="POST">
First Name: <input type="text" name="first_name" value="<%= request.getParameter("first_name")%>">
<br />
Last Name: <input type="text" name="last_name" value="<%= request.getParameter("last_name")%>"/>
<input type="submit" value="Submit" />
</form>

<p>
<form action="params.jsp" method="POST" >
<input type="checkbox" name="maths" checked="checked" /> Maths
<input type="checkbox" name="physics"  /> Physics
<input type="checkbox" name="chemistry" checked="checked" /> Chemistry
<input type="submit" value="Select Subject" />
</form>

<center>
<h1>Reading Checkbox Data</h1>
<ul>
<li><p><b>Maths Flag:</b>
   <%= request.getParameter("maths")%>
</p></li>
<li><p><b>Physics Flag:</b>
   <%= request.getParameter("physics")%>
</p></li>
<li><p><b>Chemistry Flag:</b>
   <%= request.getParameter("chemistry")%>
</p></li>
</ul>
</center>


<p>
<center>
<h2>HTTP Header Request Example</h2>
<table width="100%" border="1" align="center">
<tr bgcolor="#949494">
<th>Param Name</th><th>Param Value(s)</th>
</tr>
<%
   Enumeration<String> paramNames = request.getParameterNames();

   while(paramNames.hasMoreElements()) {
      String paramName = (String)paramNames.nextElement();
      out.print("<tr><td>" + paramName + "</td>\n");
      //String paramValue = request.getHeader(paramName);
      String paramValue = request.getParameter(paramName);
      out.println("<td> " + paramValue + "</td></tr>\n");
   }
%>
</table>
</center>

</body>
</html>