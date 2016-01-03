<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
Integer userId = 0;
String nome = "";
if (session.getAttribute("userId") != null) {
	userId = (Integer)session.getAttribute("userId");
	nome = (String) session.getAttribute("nome");
	}
%>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			<div id="bookingLogo" >
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
				<div id="checkout" align="right">
					<a href="<%=request.getContextPath()%>/LogoutServlet">
					<img src="<%=request.getContextPath()%>/images/shutdown.png" alt="Uscita"/>
					</a>
				</div>
			</td>
</c:if>			
			
		</tr>
</table>
