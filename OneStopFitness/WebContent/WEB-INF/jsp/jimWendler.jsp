<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp" />
<div class="callout-light text-center fade-in-b">
	<h1>
		Learn more about Jim Wendler 5/3/1<br>
		<a href="http://www.jimwendler.com/" target="_blank" class="btn btn-success"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;More Info</a>
	</h1>
</div>
<div class="container">
	<h3>Build your Jim Wendler 5/3/1 program</h3>
	Each training cycle last four weeks, with these set-rep goals for each major lift:
	<table class="table table-condensed table-striped">
		<tr>
			<th>Week 1</th>
			<th>Week 2</th>
			<th>Week 3</th>
			<th>Week 4</th>
		</tr>
		<tr>
			<td>3 sets, 5 reps</td>
			<td>3 sets, 3 reps</td>
			<td>3 sets, 5 reps, 3 reps, 1 rep</td>
			<td>Deload</td>
		</tr>
	</table>
	<h4>Enter your one rep max in order to calculate your working sets:</h4>
	<div id="jwOneRepMaxAlert" class="alert alert-danger" role="alert" style="display:none;">
    	<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	  	<span class="sr-only">Error:</span>
	  	Enter a one rep max between 1 and 1200.
	</div>
	<div class="input-group">
		<input id="jwOneRepMax" class="form-control" placeholder="One Rep Max" />
		<span class="input-group-btn">
        	<button id="jwOneRepMaxButton" class="btn btn-success" type="button"><span class="glyphicon glyphicon-refresh"></span></button>
      	</span>
	</div>
	<div id="jwTable"></div>
</div>
<script src="${pageContext.request.contextPath}/js/jimWendler.js"></script>
<jsp:include page="footer.jsp" />