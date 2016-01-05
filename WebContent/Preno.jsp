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
        <title><fmt:message key="preno.title" bundle="${lang}" /></title>
        
<script type="text/javascript">
$(function() {
    $( "#dataPreno" ).datepicker({ dateFormat: 'dd/mm/yy', minDate: 'today', maxDate: 'today+10d' });
  });
  
  
// $('.dataPreno').change(function() {
// 	  var date2 = $('.dataPreno').datepicker('getDate', '+1d'); 
// 	  echo date2;	//
// 	}); 

</script>

<style type="text/css">
  table.preno th {
    width: 30px;
    overflow: hidden;
    display: inline-block;
    white-space: nowrap;
    text-align: center;
    }
  table.preno td {
    width: 30px;
    overflow: hidden;
    display: inline-block;
    white-space: nowrap;
    text-align: center;
}
</style>

</head>
<body>

<% String action = request.getParameter("action");
%>

	<form method="POST" action='PrenoController' name="frmPreno">
	
		<div>
			<label for="dataPreno"><fmt:message key="preno.label.dataPreno" bundle="${lang}" />:</label>
			<input type="text" name="dataPreno" id="dataPreno" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${dataPreno}" />" >
		</div>
	
		<input type="submit" value="<fmt:message key="submit" bundle="${lang}" />" />
	</form>


<table class="preno" border=1>
        <thead>
            <tr>
               	<th><fmt:message key="preno.label.campo" bundle="${lang}" /></th>
               	<c:forEach items="${beans[0].getPrenoHead()}" var="bean">
               		<th><c:out value="${bean}" /></th>
               	</c:forEach>
               	
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${beans}" var="bean">
                <tr>
                	<td>
                	<c:out value="${bean.campo.nome}" />
                	</td>
                	
                	<c:forEach items="${bean.getPrenoColored()}" var="bean" varStatus="loop">
                	
<%--                 		${loop.index} --%>
                		
               			<td bgcolor="${bean.color}"><c:out value=" " /></td>
               		</c:forEach>
                	
                </tr>
            </c:forEach>
        </tbody>
    </table>




</body>
</html>