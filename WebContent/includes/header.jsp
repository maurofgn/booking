<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
Integer userId = 0;
String nome = "";
if (session.getAttribute("userId") != null) {
	userId = (Integer)session.getAttribute("userId");
	nome = (String) session.getAttribute("nome");
	}
%>


<style type="text/css">
  table.header {
    width: 100%;
    border=0; 
    cellspacing=0;
    cellpadding=0;
    overflow: hidden;
    display: inline-block;
    white-space: nowrap;
/*     text-align: center; */
    }
  table.header th {
    width: 30px;
    overflow: hidden;
    display: inline-block;
    white-space: nowrap;
    text-align: center;
    }
  table.header td {
    width: 30px;
    overflow: hidden;
    display: inline-block;
    white-space: nowrap;
    text-align: center;
}
</style>


<table class="header">
		<tr>
			<td>
			<div id="bookingLogo" align="left" >
			<a href="<%=request.getContextPath()%>">
				<img src="<%=request.getContextPath()%>/images/logo.png" alt="Booking"/>
			</a>
			</div>
			</td>
			
			
<c:if test="${userId > 0}">
			<td>
				<div id="wellcome" align="right">
					Utente: 
					<a href="<%=request.getContextPath()%>/PersonaController?action=edit&id=<%=userId %>">
						<%=nome%>
					</a>
				</div>			
			</td>
			
			<td>
				<div id="checkout" align="center">
					<a href="<%=request.getContextPath()%>/LogoutServlet">
					<img src="<%=request.getContextPath()%>/images/shutdown.png" alt="Uscita"/>
					</a>
				</div>
			</td>
</c:if>			
			
		</tr>
</table>
