<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${pageContext.request.locale }"/>
<fmt:setBundle basename="loc"/>

<a href="${requestScope['javax.servlet.forward.request_uri']}?language=en_US"><fmt:message key="english"/></a>
<a href="${requestScope['javax.servlet.forward.request_uri']}?language=ru"><fmt:message key="russian"/></a>

<%--<select name="locale" onchange="this.value">--%>
    <%--<option value="${requestScope['javax.servlet.forward.request_uri']}?lang=en_US" ${pageContext.request.locale eq 'en_US' ? 'selected' : ''}><fmt:message key="english"/></option>--%>
    <%--<option value="${requestScope['javax.servlet.forward.request_uri']}?lang=ru" ${pageContext.request.locale eq 'ru' ? 'selected' : ''}><fmt:message key="russian"/></option>--%>
<%--</select>--%>
