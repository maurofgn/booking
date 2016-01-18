<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="org.mf.i18n.Message" var="lang" />

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Add new societa'</title>
</head>
<body>

		<form method="POST" action='SocietaController' name="frmAddSocieta">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            
            <input type="hidden" name="id" id="id" value="<c:out value="${bean.id}" />" />
            
				<div>
					<label for="nome"><fmt:message key="societa.label.nome" bundle="${lang}" />:</label>
					<input type="text" name="nome" id="nome" value="<c:out value="${bean.nome}" />" placeholder="Nome" required>
				</div>
				
			<div><label for="citta"><fmt:message key="societa.label.citta" bundle="${lang}" />:</label> <input type="text" name="citta" id="citta" value="<c:out value="${bean.citta}" />" > </div>
			<div><label for="prov"><fmt:message key="societa.label.prov" bundle="${lang}" />:</label> <input type="text" name="prov" id="prov" value="<c:out value="${bean.prov}" />" > </div>
			<div><label for="indirizzo"><fmt:message key="societa.label.indirizzo" bundle="${lang}" />:</label> <input type="text" name="indirizzo" id="indirizzo" value="<c:out value="${bean.indirizzo}" />" > </div>
			<div><label for="codFederale"><fmt:message key="societa.label.codiceFederale" bundle="${lang}" />:</label> <input type="text" name="codiceFederale" id="codiceFederale" value="<c:out value="${bean.codiceFederale}" />" > </div>
			<div><label for="giorniRitardoAmmesso"><fmt:message key="societa.label.giorniRitardoAmmesso" bundle="${lang}" />:</label> <input type="text" name="giorniRitardoAmmesso" id="giorniRitardoAmmesso" value="<c:out value="${bean.giorniRitardoAmmesso}" />" > </div>
			<div><label for="site"><fmt:message key="societa.label.site" bundle="${lang}" />:</label> <input type="text" name="site" id="site" value="<c:out value="${bean.site}" />" > </div>
			<div><label for="mail"><fmt:message key="societa.label.mail" bundle="${lang}" />:</label> <input type="text" name="mail" id="mail" value="<c:out value="${bean.mail}" />" > </div>
			<div><label for="personaId"><fmt:message key="societa.label.personaId" bundle="${lang}" />:</label> <input type="text" name="personaId" id="personaId" value="<c:out value="${bean.personaId}" />" > </div>

			<input type="submit" value="<fmt:message key="submit" bundle="${lang}" />" />
			
			<input type="button" onclick="location.href='<%=request.getContextPath() %>/SocietaController?action=delete&id=${bean.id}';" value="<fmt:message key="delete" bundle="${lang}"/>" />

	</form>
</body>
</html>