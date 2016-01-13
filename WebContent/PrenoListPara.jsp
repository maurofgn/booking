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
        <title><fmt:message key="PrenoList.Para.Title" bundle="${lang}"/></title>
        
<script type="text/javascript">
$(function() {
    $( "#dataPreno" ).datepicker({ dateFormat: 'dd/mm/yy', minDate: 'today-5Y', maxDate: 'today+15D' });
  });
</script>

    </head>
    <body>
        <form method="POST" action='PrenoController' name="frmPrenoListPara">

<input type="hidden" name="action" id="action" value="<c:out value="${action}" />" />
<div><label for="dataPreno"><fmt:message key="preno.label.dataPreno" bundle="${lang}" />:</label> <input type="text" name="dataPreno" id="dataPreno" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.nascita}" />" > </div>
<div><label for="nomePersona"><fmt:message key="persona.label.nome" bundle="${lang}" />:</label> <input type="text" name="nomePersona" id="nomePersona" value="<c:out value="${bean.cognome}" />" > </div>
<div><label for="cognomePersona"><fmt:message key="persona.label.cognome" bundle="${lang}" />:</label> <input type="text" name="cognomePersona" id="cognomePersona" value="<c:out value="${bean.cognome}" />" > </div>
<div><label for="nomeCampo"><fmt:message key="campo.label.nome" bundle="${lang}" />:</label> <input type="text" name="nomeCampo" id="nomeCampo" value="<c:out value="${bean.citta}" />" > </div>
<div><label for="nomeSocieta"><fmt:message key="societa.label.nome" bundle="${lang}" />:</label> <input type="text" name="nomeSocieta" id="nomeSocieta" value="<c:out value="${bean.prov}" />" > </div>

			<input type="submit" value="<fmt:message key="submit" bundle="${lang}" />" />
	</form>
    </body>
</html>