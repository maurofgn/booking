<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<title>JSTL fmt:message Tag</title>
</head>
<body>

<fmt:setBundle basename="booking.i18n.Message" var="lang" scope="session"/>
<%-- <fmt:setLocale value="it" scope="session"/> --%>

<fmt:message key="count.one" bundle="${lang}"/><br/>
<fmt:message key="login.label.username" bundle="${lang}"/><br/>
<fmt:message key="login.label.password" bundle="${lang}"/><br/>

</body>
</html>