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
               	<th>Nome</th>
				<th>Città</th>
				<th>Provincia</th>
				<th>Indirizzo</th>
				<th>Codice Federale</th>
				<th>Ritardo ammesso (gg)</th>
				<th>Site</th>
				<th>e-mail</th>
				<th>Custode</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach items="${beans}" var="bean">
                <tr>
                	<td>
                	<a href="SocietaController?action=edit&id=<c:out value="${bean.id}"/>">
                	<c:out value="${bean.nome}" /></a></td> 
					<td><c:out value="${bean.citta}" /></td>
					<td><c:out value="${bean.prov}" /></td>
					<td><c:out value="${bean.indirizzo}" /></td>
					<td><c:out value="${bean.codiceFederale}" /></td>
					<td><c:out value="${bean.giorniRitardoAmmesso}" /></td>
					<td><c:out value="${bean.site}" /></td>
					<td><c:out value="${bean.mail}" /></td>
					<td><c:out value="${bean.persona.nomeCompleto}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="SocietaController?action=insert">Add</a></p>
</body>
</html>
