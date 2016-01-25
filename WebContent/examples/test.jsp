<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Random" %>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%-- This comment will not be visible in the page source
dichiarazione (con !)
 --%> 
<%!
int casuale = 0;
java.util.Date oggi = new java.util.Date();
GregorianCalendar gc = new GregorianCalendar();
int dayOfMonth = gc.get(GregorianCalendar.DAY_OF_MONTH);
int dayOfWeek = gc.get(GregorianCalendar.DAY_OF_WEEK);
DateFormat df = SimpleDateFormat.getDateInstance(SimpleDateFormat.MEDIUM, Locale.ITALY);
DateFormat tf = SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, Locale.ITALY);
%>
 
 <%-- This comment will not be visible in the page source
scriptlet (senza !)
 --%>  
 <%
 casuale = randInt(0, 1000);
 %>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>titolo di test.jsp</title>
</head>
<body>
	<p>
		<!-- questo tipo di commento non è considerato commento dall''engine jsp ma è considerato commento dal browser (commento html) -->
		Data attuale: <%=df.format(oggi)%> ora: <%=tf.format(oggi)%>
		<br>
		<% 
		out.println("Il tuo indirizzo IP &egrave; " + request.getRemoteAddr());
		%>
		
		<br> Il valore casuale della variabile casuale &egrave;
		<%= casuale%>
		<br>
		<% casuale++; %>
		Il valore della variabile casuale dopo l'incremento &egrave;
		<%= casuale%>
		<%
			if (casuale % 2 == 0) {
		%>
		<p>il numero casuale <%= casuale%> è pari</p>
		<%
			} else {
		%>
		<p>il numero casuale <%= casuale%> è dispari</p>
		<%
			}
		%>


<% 
out.println("<p> Il giorno della settimana è " + dayOfWeek + " ed è ");
switch(dayOfWeek) {
case GregorianCalendar.SUNDAY:
   out.println("Domenica");
   break;
case GregorianCalendar.MONDAY:
   out.println("Lunedì.");
   break;
case GregorianCalendar.TUESDAY:
   out.println("Martedì.");
   break;
case GregorianCalendar.WEDNESDAY:
   out.println("Mercoledì.");
   break;
case GregorianCalendar.THURSDAY:
   out.println("Giovedì.");
   break;
case GregorianCalendar.FRIDAY:
   out.println("Venerdì.");
   break;
case GregorianCalendar.SATURDAY:
   out.println("Sabato.");
   break;
default:
   out.println("NON DEFINITO.");
}

out.println("</p>");
%>


<%-- esempio di ciclo for --%> 
<%! int fontSize; %> 

<%for ( fontSize = 1; fontSize <= 3; fontSize++){ %>
   <font color="green" size="<%= fontSize %>">
    JSP Tutorial
   </font><br />
<%}%>

<%-- esempio di ciclo while --%>
<%
fontSize = 1;
while ( fontSize <= 3){ %>
   <font size="<%= fontSize %>">
    <a href="http://www.tutorialspoint.com/jsp/jsp_syntax.htm">JSP Tutorial syntax</a>
   </font><br />
<%fontSize++;%>
<%}%>


Server info: <%= application.getServerInfo() %><br>
<font color="red" size="8">
Servlet version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %>
</font><br />
JSP version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %><br>
Java version: <%= System.getProperty("java.version") %><br>

</body>
</html>

<%!
public static int randInt(int min, int max) {

    // NOTE: Usually this should be a field rather than a method
    // variable so that it is not re-seeded every call.
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
%> 