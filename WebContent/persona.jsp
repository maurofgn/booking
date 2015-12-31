<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="org.mf.i18n.Message" var="lang" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new user</title>
        
<script type="text/javascript">
$(function() {
    $( "#nascita" ).datepicker({ dateFormat: 'dd/mm/yy' });
  });
</script>

    </head>
    <body>
        <form method="POST" action='PersonaController' name="frmAddPersona">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            
				<div>
					<label for="nome"><fmt:message key="persona.label.nome" bundle="${lang}" />:</label>
					<input type="text" name="nome" id="nome" value="<c:out value="${bean.nome}" />" placeholder="Nome" required>
				</div>

<div><label for="cognome"><fmt:message key="persona.label.cognome" bundle="${lang}" />:</label> <input type="text" name="cognome" id="cognome" value="<c:out value="${bean.cognome}" />" > </div>
<div><label for="citta"><fmt:message key="persona.label.citta" bundle="${lang}" />:</label> <input type="text" name="citta" id="citta" value="<c:out value="${bean.citta}" />" > </div>
<div><label for="prov"><fmt:message key="persona.label.prov" bundle="${lang}" />:</label> <input type="text" name="prov" id="prov" value="<c:out value="${bean.prov}" />" > </div>
<div><label for="indirizzo"><fmt:message key="persona.label.indirizzo" bundle="${lang}" />:</label> <input type="text" name="indirizzo" id="indirizzo" value="<c:out value="${bean.indirizzo}" />" > </div>
<div><label for="telefono"><fmt:message key="persona.label.telefono" bundle="${lang}" />:</label> <input type="text" name="telefono" id="telefono" value="<c:out value="${bean.telefono}" />" > </div>
<div><label for="mail"><fmt:message key="persona.label.mail" bundle="${lang}" />:</label> <input type="text" name="mail" id="mail" value="<c:out value="${bean.mail}" />" > </div>
<div><label for="codFisc"><fmt:message key="persona.label.codFisc" bundle="${lang}" />:</label> <input type="text" name="codFisc" id="codFisc" value="<c:out value="${bean.codFisc}" />" > </div>
<div><label for="nascita"><fmt:message key="persona.label.nascita" bundle="${lang}" />:</label> <input type="text" name="nascita" id="nascita" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.nascita}" />" > </div>
<div><label for="sesso"><fmt:message key="persona.label.sesso" bundle="${lang}" />:</label> <input type="text" name="sesso" id="sesso" value="<c:out value="${bean.sesso}" />" > </div>

<c:if test="${'A' == ruolo}">
	<div><label for="utente"><fmt:message key="persona.label.utente" bundle="${lang}" />:</label> <input type="text" name="utente" id="utente" value="<c:out value="${bean.utente}" />" > </div>
	<div><label for="psw"><fmt:message key="persona.label.psw" bundle="${lang}" />:</label> <input type="password" name="psw" id="psw" value="<c:out value="${bean.psw}" />" > </div>
	<div><label for="ruolo"><fmt:message key="persona.label.ruolo" bundle="${lang}" />:</label> <input type="text" name="ruolo" id="ruolo" value="<c:out value="${bean.ruolo}" />" > </div>
</c:if>

			<input type="submit" value="Submit" />
	</form>
    </body>
</html>