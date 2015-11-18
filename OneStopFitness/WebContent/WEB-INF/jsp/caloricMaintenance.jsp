<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp" />
<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">Caloric Maintenance Level Calculator</div>
	  	<div class="panel-body form-horizontal">
	  		<div class="row">
		  		<div class="form-group">
		  			<label class="control-label col-lg-1 col-md-1">Gender</label>
		  			<div class="col-lg-5 col-md-5">
				  		<select id="gender" class="form-control">
				  			<option value="">Select...</option>
				  			<option value="M">Male</option>
				  			<option value="F">Female</option>
				  		</select>
			  		</div>
		  		</div>
	  		</div>
	  		<div class="row">
		  		<div class="form-group">
		  			<label class="control-label col-lg-1 col-md-1">Height</label>
		  			<div class="col-lg-11 col-md-11">
						<div class="btn-group" role="group">
						  <button id="4" type="button" class="btn btn-default feet-btn">4</button>
						  <button id="5" type="button" class="btn btn-default feet-btn">5</button>
						  <button id="6" type="button" class="btn btn-default feet-btn">6</button>
						</div>&nbsp;Feet&nbsp;
						<div class="btn-group" role="group">
						  <button id="1" type="button" class="btn btn-default inches-btn">1</button>
						  <button id="2" type="button" class="btn btn-default inches-btn">2</button>
						  <button id="3" type="button" class="btn btn-default inches-btn">3</button>
						  <button id="4" type="button" class="btn btn-default inches-btn">4</button>
						  <button id="5" type="button" class="btn btn-default inches-btn">5</button>
						  <button id="6" type="button" class="btn btn-default inches-btn">6</button>
						  <button id="7" type="button" class="btn btn-default inches-btn">7</button>
						  <button id="8" type="button" class="btn btn-default inches-btn">8</button>
						  <button id="9" type="button" class="btn btn-default inches-btn">9</button>
						  <button id="10" type="button" class="btn btn-default inches-btn">10</button>
						  <button id="11" type="button" class="btn btn-default inches-btn">11</button>
						  <button id="12" type="button" class="btn btn-default inches-btn">12</button>
						</div>&nbsp;Inches
			  		</div>
		  		</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6">
			  		<div class="form-group">
			  			<label class="control-label col-lg-2 col-md-2">Age</label>
			  			<div class="col-lg-10 col-md-10">
							<input id="age" class="form-control" placeholder="Age"/>
				  		</div>
			  		</div>
		  		</div>
		  		<div class="col-lg-6 col-md-6">
			  		<div class="form-group">
			  			<label class="control-label col-lg-2 col-md-2">Weight</label>
			  			<div class="col-lg-10 col-md-10">
							<input id="weight" class="form-control" placeholder="Weight in lbs" />
				  		</div>
			  		</div>
		  		</div>
			</div>
	  		<div class="row">
		  		<div class="form-group">
		  			<label class="control-label col-lg-1 col-md-1">Active</label>
		  			<div class="col-lg-6 col-md-6">
				  		<select id="activityLevel" class="form-control">
				  			<option value="">Select...</option>
				  			<option value="1.2">Little or no exercise</option>
				  			<option value="1.375">Light Activity</option>
				  			<option value="1.550">Moderate Activity</option>
				  			<option value="1.725">Very Active</option>
				  			<option value="1.9">Extremely Active</option>
				  		</select>
			  		</div>
		  		</div>
	  		</div>
	  		<div id="calorie-maintenance-level-display" style="display:none;text-align:center;padding-bottom: 7px;"></div>
			<button id="calculateBtn" class="btn btn-block btn-success"><span class="glyphicon glyphicon-stats"></span>&nbsp;Estimate daily calorie maintenance level</button>
	  	</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/caloricMaintenanceLevel.js"></script>
<jsp:include page="footer.jsp" />