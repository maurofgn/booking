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
        <title>Add new socio</title>
        
<script type="text/javascript">
$(function() {
    $( "#scadenza" ).datepicker({ dateFormat: 'dd/mm/yy', minDate: 'today-100Y', maxDate: 'today' });
  });
</script>


</head>
		<body>
		<form method="POST" action='SocioController' name="frmAddSocio">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            
            <input type="hidden" name="id" id="id" value="<c:out value="${bean.id}" />" />
				
				<div>
					<label for="tessera"><fmt:message key="socio.label.tessera" bundle="${lang}" />:</label>
					<input type="text" name="tessera" id="tessera" value="<c:out value="${bean.tessera}" />" placeholder="Tessera" required>
				</div>
				
<div><label for="annoInizio"><fmt:message key="socio.label.annoInizio" bundle="${lang}" />:</label> <input type="text" name="annoInizio" id="annoInizio" value="<c:out value="${bean.annoInizio}" />" > </div>
<div><label for="scadenza"><fmt:message key="socio.label.scadenza" bundle="${lang}" />:</label> <input type="text" name="scadenza" id="scadenza" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.scadenza}" />" > </div>


<%-- <div><label for="societaId"><fmt:message key="socio.label.societaId" bundle="${lang}" />:</label> <input type="text" name="societaId" id="societaId" value="<c:out value="${bean.societa.nome}" />" > </div> --%>
<%-- <div><label for="personaId"><fmt:message key="socio.label.personaId" bundle="${lang}" />:</label> <input type="text" name="personaId" id="personaId" value="<c:out value="${bean.persona.nome}" />" > </div> --%>


<div><label for="societaId"><fmt:message key="socio.label.societaId" bundle="${lang}" />:</label> 

	<select name="societaId" id="societaId">
	    <c:forEach var="item" items="${societaList}">
	        <option value="${item.id}" ${item.id == bean.societaId ? 'selected="selected"' : ''}>${item.nome}</option>
	    </c:forEach>
	</select>

</div>

<div><label for="personaId"><fmt:message key="socio.label.personaId" bundle="${lang}" />:</label> 

	<select name="personaId" id="personaId">
	    <c:forEach var="item" items="${personeList}">
	        <option value="${item.id}" ${item.id == bean.personaId ? 'selected="selected"' : ''}>${item.nomeCompleto}</option>
	    </c:forEach>
	</select>

</div>



			<input type="submit" value="<fmt:message key="submit" bundle="${lang}" />" />
			
			<input type="button" onclick="location.href='<%=request.getContextPath() %>/SocioController?action=delete&id=${bean.id}';" value="<fmt:message key="delete" bundle="${lang}"/>" />
	</form>

		</body>
</html>