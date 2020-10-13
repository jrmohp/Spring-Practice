<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>


<title>
	Custom Login
</title>

<body>

	
		<form:form action="${pageContext.request.contextPath}/authuser" method="POST">
	
		<c:if test="${param.error !=null }">
		
		<i>Sorry! Username and Password is not valid</i>
		</c:if>
	
	
	<c:if test="${param.logout !=null }">
		
		<i>You have been logged out!</i>
		</c:if>
	
	<p>
	  User Name : <input type="text" name="username"/>
	</p>
	
	<p>
	  User Name : <input type="password" name="password"/>
	</p>
	
	<input type="submit" value="Login"/>
	
	
	
	</form:form>


</body>

</html>