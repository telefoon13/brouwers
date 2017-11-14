<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Welkom"/>
</head>
<body>
<vdab:menu/>
<h1>Welkom</h1>
<h2><spring:message code="${tekst}"/></h2>
</body>
</html>