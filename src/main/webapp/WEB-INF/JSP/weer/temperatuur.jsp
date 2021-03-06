<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Temperatuur"/>
</head>
<body>
<vdab:menu/>
<c:choose>
    <c:when test='${empty fout}'>
        <h1>Het is <fmt:formatNumber value='${temperatuur}'/> ° in ${plaats}</h1>
    </c:when>
    <c:otherwise>
        <div class='fout'>${fout}</div>
    </c:otherwise>
</c:choose>

</body>
</html>