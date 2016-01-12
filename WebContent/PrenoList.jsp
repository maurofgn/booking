<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
               	<th>campo</th>
               	<th>nome</th>
				<th>cognome</th>
				<th>data</th>
				<th>ora</th>
<!--				<th>citta</th>
 				<th>prov</th>
				<th>indirizzo</th>
				<th>telefono</th>
				<th>mail</th>
				<th>codFisc</th>
				<th>psw</th>
				<th>utente</th>
				<th>ruolo</th>
				<th>Nascita</th>
				<th>sesso</th> -->
<!--                 <th colspan=2>Action</th> -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${beans}" var="bean">
                <tr>
                	<td><c:out value="${bean.campo}" /></td>
					<td><c:out value="${bean.nome}" /></td>
					<td><c:out value="${bean.cognome}" /></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${bean.data}" /></td>
					<td align="right"><c:out value="${bean.ora}" /></td>
<%-- 					
					<td><c:out value="${bean.prov}" /></td>
					<td><c:out value="${bean.indirizzo}" /></td>
					<td><c:out value="${bean.telefono}" /></td>
					<td><c:out value="${bean.mail}" /></td>
					<td><c:out value="${bean.codFisc}" /></td>
					<td><c:out value="${bean.psw}" /></td>
					<td><c:out value="${bean.utente}" /></td>
					<td><c:out value="${bean.ruolo}" /></td>
					<td><fmt:formatDate pattern="dd MMM,yyyy" value="${bean.nascita}" /></td>
					<td><c:out value="${bean.sesso}" /></td>
					 --%>
					
<%--                     <td><a href="PersonaController?action=edit&id=<c:out value="${bean.id}"/>">Update</a></td> --%>
<%--                     <td><a href="PersonaController?action=delete&id=<c:out value="${bean.id}"/>">Delete</a></td> --%>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
<%--     <fmt:message key="preno.action.Preno" bundle="${lang}"/> --%>

<%-- 	<p><a href="<%=request.getContextPath()%>/PrenoController"><fmt:message key="preno.action.Preno" bundle="${lang}"/></a></p> --%>
    <p><a href="<%=request.getContextPath()%>/PrenoController">Prenotazioni</a></p>

</body>
</html>
