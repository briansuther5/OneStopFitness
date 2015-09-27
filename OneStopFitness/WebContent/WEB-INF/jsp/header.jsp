<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Brian Suther">
    <link rel="icon" href="${pageContext.request.contextPath}/img/OneStopFitnessNavLogo.png">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	<title>One Stop Fitness</title>
  </head>
  <body>
  	<c:choose>
		<c:when test="${userProfile != null and not empty userProfile.username}">
			<jsp:include page="loggedInUserNavbar.jsp" />
		</c:when>
		<c:otherwise>
			<jsp:include page="loggedOutUserNavbar.jsp" />
		</c:otherwise>
	</c:choose>
	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="${loginModalDisplay}">
    	<div class="modal-dialog">
			<div class="loginmodal-container">
				<h1>Login to Your Account</h1><br>
			  	<form:form class="form-horizontal" modelAttribute="userProfile" action="${pageContext.request.contextPath}/app/account/login" method="POST">
					<c:if test="${invalidCredentials}">
						<div id="new-user-error-notice" class="notice notice-danger">
							<strong>Incorrect username or password.</strong>
						</div>
					</c:if>
					<form:input type="text" path="username" placeholder="Username" />
					<form:input type="password" path="password" placeholder="Password" />
					<input type="submit" class="login loginmodal-submit" value="Login" />
			  	</form:form>
			  	<div class="login-help">
					<a href="${pageContext.request.contextPath}/app/account/create">Register</a>&nbsp;&nbsp;<a href="#">Forgot Password</a>
			  	</div>
			</div>
		</div>
	</div>
	
	<script>
		<c:if test="${accountCreated or invalidCredentials}">
			$("#login-modal").modal("show");
		</c:if>
		var eOsfContextHolder = {
			contextPath : '${pageContext.request.contextPath}',
			osfLogo : '${pageContext.request.contextPath}/img/OneStopFitnessNavLogo.png'
		};
	</script>
