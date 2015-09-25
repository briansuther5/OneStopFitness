<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<style>
    .header {
        color: #00003d;
        font-size: 27px;
        padding: 10px;
    }

    .bigicon {
        font-size: 35px;
        color: #a30000;
    }
</style>

<jsp:include page="header.jsp" />

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">
                <form:form class="form-horizontal" modelAttribute="userProfile" action="${pageContext.request.contextPath}/app/account/save" method="POST">
                    <fieldset>
                        <legend class="text-center header">Account Registration</legend>
                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center hidden-xs hidden-sm"><i class="fa fa-user bigicon"></i></span>
                            <div class="col-md-8">
                                <form:input type="text" path="username" class="form-control" placeholder="Username" />
                            </div>
                        </div>
                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center hidden-xs hidden-sm"><i class="fa fa-user bigicon"></i></span>
                            <div class="col-md-8">
                                <form:input type="text" path="firstName" class="form-control" placeholder="First Name" />
                            </div>
                        </div>
                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center hidden-xs hidden-sm"><i class="fa fa-user bigicon"></i></span>
                            <div class="col-md-8">
                                <form:input type="text" path="lastName" class="form-control" placeholder="Last Name" />
                            </div>
                        </div>

                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center hidden-xs hidden-sm"><i class="fa fa-envelope-o bigicon"></i></span>
                            <div class="col-md-8">
                                <form:input type="text" path="email" class="form-control" placeholder="Email" />
                            </div>
                        </div>

                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center hidden-xs hidden-sm"><i class="fa fa-key bigicon"></i></span>
                            <div class="col-md-8">
                                <form:input type="password" path="password" class="form-control" placeholder="Password" />
                            </div>
                        </div>

                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center hidden-xs hidden-sm"><i class="fa fa-key bigicon"></i></span>
                            <div class="col-md-8">
                                <input id="confirmPassword" type="password" class="form-control" placeholder="Confirm Password" />
                            </div>
                        </div>

						<div class="col-lg-6 col-md-6">
							<button type="submit" class="btn btn-primary btn-block btn-lg"><span class="glyphicon glyphicon-user"></span>&nbsp;Create Account</button>
						</div>
						<div class="col-lg-6 col-md-6">
							<a href="${pageContext.request.contextPath}/app/summary/view" class="btn btn-success btn-block btn-lg"><span class="glyphicon glyphicon-remove"></span>&nbsp;Cancel</a>
						</div>
                    </fieldset>
                </form:form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />