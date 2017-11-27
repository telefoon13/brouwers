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
<h1>Brouwers op begin naam</h1>
<c:url value="/brouwers" var="url"/>
<form:form action="${url}" commandName="beginNaamForm" method="get">
    <form:label path="beginnaam">Begin letter(s): <form:errors path="beginnaam"/></form:label>
    <form:input path="beginnaam" autofocus="autofocus" type="search"/>
    <input type='submit' value='Zoeken'>
    <form:errors cssClass="fout"/>
</form:form>
<c:if test="${not empty brouwers}">
    <c:forEach items='${brouwers}' var='brouwer'>
        <h2>${brouwer.naam}</h2>
    </c:forEach>
</c:if>
</body>
</html>