<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>Tomcat is <b>

<c:choose>
	<c:when test="${running == 'true'}">
		RUNNING!
	</c:when>
	<c:otherwise>
		FAILING!
	</c:otherwise>
</c:choose>

${e}
