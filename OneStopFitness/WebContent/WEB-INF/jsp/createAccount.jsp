<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp" />

<div class="container">
	<form:form class="form-horizontal" modelAttribute="userProfile" action="${pageContext.request.contextPath}/app/account/save" method="POST">
		<form:hidden path="accountType"/>
		<form:input path="username" class="form-control" />
		<form:input path="firstName" class="form-control" />
		<form:input path="lastName" class="form-control" />
		<div class="col-lg-6 col-md-6">
			<button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-user"></span>&nbsp;Create Account</button>
		</div>
		<div class="col-lg-6 col-md-6">
			<a href="${pageContext.request.contextPath}/app/summary/view" class="btn btn-success btn-block"><span class="glyphicon glyphicon-remove"></span>&nbsp;Cancel</a>
		</div>
	</form:form>
</div>
<jsp:include page="footer.jsp" />