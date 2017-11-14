<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Brouwers - Zoek op begin naam"/>
</head>
<body>
<vdab:menu/>
<h1>Brouwers op begin naam</h1>
<c:forEach var="i" begin="65" end="90" step="1">
    <spring:url value="/brouwers/{beginNaam}" var="letterURL">
        <spring:param name="beginNaam" value="${&#i;}"/>
    </spring:url>
    <a href="${letterURL}"><%=Character.toChars((Integer)pageContext.getAttribute("i"))%></a>
</c:forEach>
</body>
</html>