<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Groene tenen"/>
</head>
<body>
<vdab:menu/>
<h1>Brouwers op alfabet ${empty param.letter ? "" : param.letter}</h1>
<ul class='zonderbolletjes'>
    <c:forEach items='${alfabet}' var='letter'>
        <c:url value='/brouwers' var='letterURL'>
            <c:param name='letter' value='${letter}'/>
        </c:url>
        <li><a href='${letterURL}'>${letter}</a></li>
    </c:forEach>
</ul>
<c:if test='${not empty brouwers}'>
    <ul>
        <c:forEach items='${brouwers}' var='brouwer'>
            <li>${brouwer.naam} (${brouwer.adres.gemeente})</li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>