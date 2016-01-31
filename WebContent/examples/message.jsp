<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="booking.i18n.Message" var="lang" />


<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>i18n</title>
</head>
<body>

Formattazione delle date in base al locale
=================<br/>

<jsp:useBean id="dt" class="java.util.Date" />

<fmt:setLocale value="en_US" />
In English (US): <fmt:formatDate value="${dt}" type="date" var="now" /> ${now}<br/>

<fmt:setLocale value="en_UK" />
In English (UK): <fmt:formatDate value="${dt}" type="date" var="now" />${now}<br/>

<fmt:setLocale value="it" />
In Italian: <fmt:formatDate value="${dt}" type="date" var="now" />${now}<br/>

<fmt:setLocale value="en" />
In English: <fmt:formatDate value="${dt}" type="date" var="now" />${now}<br/>

<fmt:setLocale value="fr" />
In French: <fmt:formatDate value="${dt}" type="date" var="now" />${now}<br/>

=================


        <form>
            <select id="language" name="language" onchange="submit()">
                <option value="it" ${language == 'it' ? 'selected' : ''}>Italiano</option>
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="nl" ${language == 'nl' ? 'selected' : ''}>Nederlands</option>
                <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
            </select>
        </form>
        <form method="post">
            <label for="username"><fmt:message key="login.label.username" bundle="${lang}"/>:</label>
            <input type="text" id="username" name="username">
            <br>
            <label for="password"><fmt:message key="login.label.password" bundle="${lang}"/>:</label>
            <input type="password" id="password" name="password">
            <br>
            <fmt:message key="login.button.submit" var="buttonValue" bundle="${lang}" />
            <input type="submit" name="submit" value="${buttonValue}">
        </form>
</body>
</html>

