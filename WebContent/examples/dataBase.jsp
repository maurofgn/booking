<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SELECT Operation</title>
</head>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/booking"
     user="root"  password="toor"/>

<sql:query dataSource="${snapshot}" var="result">
SELECT * FROM Persona;
</sql:query>
 
<table border="1" width="100%">
<tr>
   <th>nome</th>
   <th>cognome</th>
   <th>citta</th>
   <th>prov</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>

   <td><c:out value="${row.nome}"/></td>
   <td><c:out value="${row.cognome}"/></td>
   <td><c:out value="${row.citta}"/></td>
   <td><c:out value="${row.prov}"/></td>
</tr>
</c:forEach>
</table>
 
</body>
</html>
