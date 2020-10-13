
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>

<html>

<body>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">

<input type="submit" value="Logout">

</form:form>

Welcome Yohoo!

<hr>

<p>
User : <security:authentication property="principal.username"/>
<br><br>
Role : <security:authentication property="principal.authorities"/>
</p>


<hr>



<!-- show only to manager -->

<security:authorize access="hasRole('MANAGER')">
<a href="${pageContext.request.contextPath}/manager">Manager Page</a>
</security:authorize>

</body>


</html>