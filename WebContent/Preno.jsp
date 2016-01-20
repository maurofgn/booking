<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="org.mf.i18n.Message" var="lang"/>

<%@ page import="org.mf.modelView.PrenoState" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="preno.title" bundle="${lang}"/></title>
        
<script type="text/javascript">

$(function() {
	
    $("#dataPreno").datepicker({ dateFormat: 'dd/mm/yy', minDate: 'today', maxDate: 'today+10d' });
    
    $("#frmPrenoSend").submit(function (e) {
    	allcheck();
    });
    
//     $('#test').click(function() {
//     	allcheck();
// 	});
        
    /* Scorre la tabella tablePreno e per tutti i checkbox estrae le variazioni */
    function allcheck() {
    	var allHours = {"data":"", "hours":[]};
    	allHours.data = document.getElementById('dataPreno').value;
    	
    	$("#tablePreno :input").each(function () {
 		    if (this.type.toLowerCase() == 'checkbox') {
   		    	if (! (
   		    		(this.value == '${PrenoState.MiaPreno}' && this.checked == true ) ||
   		    		(this.value == '${PrenoState.Libero}' && this.checked == false )
   		    		)) 
  		    	{
   		            var res = this.id.split(",");
   		            var hh = { "campo": "", "ora": "", "stato": "", "checked": ""};
   		            hh.campo = res[0];
   		            hh.ora = this.name;
   		            hh.stato = this.value;
   		            hh.checked = this.checked;
   		         	allHours.hours.push(hh);
 		    	}
		    }
		});
     	
//     	alert(JSON.stringify(allHours));
    	$('#matrix').val(JSON.stringify(allHours));
    }
    
/*
	$('.oneHourMinus').on('change', function() {
    	var $checkbox = $(this); 
		alert("Sprenota "  +  $checkbox.is(':checked') + " ora:" + $checkbox.prop('value') + " campo:" + $checkbox.prop('name'));
    }); 
    
     $('.oneHourPlus').on('change', function() {
    	var $checkbox = $(this);
		alert("Prenota " +  $checkbox.is(':checked') + " ora:" + $checkbox.prop('value') + " campo" + $checkbox.prop('name'));
     }); 
*/
    
  });

</script>

<style type="text/css">
table.preno th {
  width: 30px;
  overflow: hidden;
  display: inline-block;
  white-space: nowrap;
  text-align: center;
  }
table.preno th.campo {
  width: 150px;
  overflow: hidden;
  display: inline-block;
  white-space: nowrap;
  text-align: left;
  }
table.preno th.fondo {
  width: 100px;
  overflow: hidden;
  display: inline-block;
  white-space: nowrap;
  text-align: left;
  }
  
table.preno td {
  width: 30px;
  overflow: hidden;
  display: inline-block;
  white-space: nowrap;
  text-align: center;
}
table.preno td.campo {
    width: 150px;
    overflow: hidden;
    display: inline-block;
    white-space: nowrap;
    text-align: left;
}
table.preno td.fondo {
    width: 100px;
    overflow: hidden;
    display: inline-block;
    white-space: nowrap;
    text-align: left;
}

.Libero {
            -moz-box-shadow: inset 0px 1px 0px 0px #3dc21b;
            -webkit-box-shadow: inset 0px 1px 0px 0px #3dc21b;
            background-color: #44c767;
            border: 1px solid #18ab29;
            display: inline-block;
            cursor: pointer;
            color: #ffffff;
            font-family: Arial;
            font-size: 16px;
            font-weight: bold;
            padding: 8px 10px;
            text-decoration: none;
        }

.Libero:hover {
            background-color: #5cbf2a;
        }

.Libero:active {
            position: relative;
        }

.Occupato {
            -moz-box-shadow: inset 0px 1px 0px 0px #3dc21b;
            -webkit-box-shadow: inset 0px 1px 0px 0px #3dc21b;
            background-color: #E00000;
            border: 1px solid #B00000;
            display: inline-block;
/*             cursor: pointer; */
            color: #ffffff;
            font-family: Arial;
            font-size: 16px;
            font-weight: bold;
            padding: 8px 10px;
            text-decoration: none;
        }

/* .Occupato:hover { */
/*             background-color: #D00000; */
/*         } */

.Occupato:active {
            position: relative;
        }

.Indisponibile {
            -moz-box-shadow: inset 0px 1px 0px 0px #3dc21b;
            -webkit-box-shadow: inset 0px 1px 0px 0px #3dc21b;
            background-color: #A8A8A8;
            border: 1px solid #808080;
            display: inline-block;
/*             cursor: pointer; */
            color: #ffffff;
            font-family: Arial;
            font-size: 16px;
            font-weight: bold;
            padding: 8px 10px;
            text-decoration: none;
        }

/* .Indisponibile:hover { */
/*             background-color: #989898; */
/*         } */

.Indisponibile:active {
            position: relative;
        }
        
.MiaPreno {
            -moz-box-shadow: inset 0px 1px 0px 0px #3dc21b;
            -webkit-box-shadow: inset 0px 1px 0px 0px #3dc21b;
            background-color: #13e3f2;
            border: 1px solid #808080;
            display: inline-block;
            cursor: pointer;
            color: #ffffff;
            font-family: Arial;
            font-size: 16px;
            font-weight: bold;
            padding: 8px 10px;
            text-decoration: none;
        }

.MiaPreno:hover {
            background-color: #1374f2;
        }

.MiaPreno:active {
            position: relative;
        }        

        input.clicked {
            background-color: red;
        }

</style>
</head>
<body>

	<form method="POST" action='PrenoController' name="frmPreno">
		<div>
			<label for="dataPreno"><fmt:message key="preno.label.dataPreno" bundle="${lang}"/>:</label>
			<input type="text" 
				<c:choose>
				    <c:when test="${ruolo=='A'}">""</c:when>    
				    <c:otherwise>readonly</c:otherwise>
				</c:choose>
				name="dataPreno" 
				id="dataPreno" 
				value="<fmt:formatDate pattern="dd/MM/yyyy" value="${dataPreno}"/>" 
				onchange="this.form.submit()"
				>
		</div>
<%-- 		<input type="submit" value="<fmt:message key="submit" bundle="${lang}"/>"/> --%>
	</form>

<c:if test="${empty beans}">
	<div><fmt:message key="persona.non.tesserata" bundle="${lang}"/>
	</div>
</c:if>
<c:if test="${not empty beans}">
	<table class="preno" id="tablePreno" border=1>
        <thead>
            <tr>
               	<th class="campo"><fmt:message key="preno.label.campo" bundle="${lang}"/></th>
               	<th class="fondo"><fmt:message key="preno.label.fondo" bundle="${lang}"/></th>
               	<c:forEach items="${beans[0].getPrenoHead()}" var="bean">
               		<th><c:out value="${bean}"/></th>
               	</c:forEach>
               	
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${beans}" var="prenoRow">
                <tr>
                	<td class="campo"><c:out value="${prenoRow.campo.nome}"/></td>
                	<td class="fondo"><fmt:message key="${prenoRow.campo.tipo.keyProperty}" bundle="${lang}"/></td>
                	<c:forEach items="${prenoRow.getPreno()}" var="prenoHour" varStatus="loop">
               			<td class="${prenoHour.stato}">
               			<c:if test="${(prenoHour.stato == PrenoState.Libero) || (prenoHour.stato == PrenoState.MiaPreno)}">
               				<input 
               					class = <c:choose>
				    					 <c:when test="${prenoHour.getPersonaId() > 0}">"oneHourMinus"</c:when>    
				    					 <c:otherwise>"oneHourPlus"</c:otherwise>
									    </c:choose>
               					type="checkbox" 
               					id="${prenoRow.campo.id},${loop.index}" 
               					value="${prenoHour.stato}"
               					name="${prenoHour.hour}"
               					<c:if test="${prenoHour.getPersonaId() > 0}">checked</c:if>
               					<c:if test="${prenoHour.past}">disabled</c:if>
               				/>
               			</c:if>
               			<c:if test="${prenoHour.stato == PrenoState.Occupato && ruolo=='A'}">
               				<div><input type="hidden" name="utente" value="<c:out value="${prenoHour.utente}"/>" > </div>
               			</c:if>
               			</td>
               		</c:forEach>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <div>	
    <form method="POST" enctype="application/json" action='PrenoController' id="frmPrenoSend">
		<input type="hidden" id="action" name="action" value="save"/>
		<input type="hidden" id="matrix" name="matrix" value=""/>
		<input type="submit" value="<fmt:message key="submit" bundle="${lang}"/>"/>
		<a href="<%=request.getContextPath()%>/PrenoController?action=PrenoList"><fmt:message key="preno.action.PrenoList" bundle="${lang}"/></a>
	</form>
    </div>	
   
</c:if>
</body>
</html>