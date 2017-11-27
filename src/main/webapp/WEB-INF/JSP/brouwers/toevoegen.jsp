<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Brouwers - Zoek op begin naam"/>
</head>
<body>
<vdab:menu/>
<h1>Brouwer toevoegen</h1>
<c:url value='/brouwers' var='url'/>
<vdab:brouwerform url='${url}' knopTekst='Toevoegen'/>
</body>
</html>