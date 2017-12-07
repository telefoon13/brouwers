<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Brouwers"/>
</head>
<body>
<vdab:menu/>
<h1>Brouwers</h1>

<c:if test="${not empty brouwers}">
<table>
    <thead>
    <tr>
        <th>Nummer</th>
        <th>Naam</th>
        <th>Straat</th>
        <th>HuisNr</th>
        <th>Postcode</th>
        <th>Gemeente</th>
        <th>Omzet</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${brouwers}" var="brouwer">
        <spring:url value='/weer/{plaats}/temperatuur' var='url'>
            <spring:param name='plaats' value='${brouwer.adres.gemeente}'/>
        </spring:url>
    <tr>
        <th>${brouwer.id}</th>
        <th>${brouwer.naam}</th>
        <th>${brouwer.adres.straat}</th>
        <th>${brouwer.adres.huisNr}</th>
        <th>${brouwer.adres.postcode}</th>
        <th>${brouwer.adres.gemeente} <a href='${url}'>temperatuur</a></th>
        <th>&euro; <spring:eval expression="brouwer.omzet"/></th>
    </tr>
    </c:forEach>
    </tbody>
</table>
</c:if>
</body>
</html>