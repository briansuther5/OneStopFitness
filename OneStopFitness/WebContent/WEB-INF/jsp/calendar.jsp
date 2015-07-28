<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp" />
<link href="${pageContext.request.contextPath}/css/bootstrap-fullcalendar.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/calendar-style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/calendar-style-responsive.css" rel="stylesheet">
<style>
	.input-sm {
		margin-bottom: 8px;
	}
</style>

<section id="container">
	<section id="main-content">
		<section class="wrapper">
			<h3>Calendar</h3>
			<div class="row">
				<div class="col-lg-2">
					<h4>Add Exercise</h4>
					<div style="padding-bottom:10px;">
  				  		<input type="text" placeholder="Exercise Name" class="form-control input-sm new-exercise-name">
					  	<input type="text" placeholder="Number of reps" class="form-control input-sm new-exercise-reps">
					  	<input type="text" placeholder="Number of sets" class="form-control input-sm new-exercise-sets">
					  	<button type="button" class="btn btn-primary btn-block btn-sm add-event">Add</button>
					</div>
					<div id="external-events">
                    	<p class="drop-after">
                        	<input type="checkbox" id="drop-remove"> Remove After Drop
                        </p>
                    </div>
				</div>
				<div class="col-lg-10">
	                <section class="panel">
	                    <div class="panel-body">
	                        <div id="calendar" class="has-toolbar"></div>
	                    </div>
	                </section>
				</div>
			</div>
		</section>
	</section>
</section>

<script src="${pageContext.request.contextPath}/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fullcalendar.min.js"></script>
<script src="${pageContext.request.contextPath}/js/calendar.js"></script>
<script>
	$(document).ready(function() {
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		$('#calendar').fullCalendar({
		    header: {
		        left: 'prev,next today',
		        center: 'title',
		        right: 'month,basicWeek,basicDay'
		    },
		    editable: true,
		    droppable: true,
		    drop: function(date, allDay) {
		        var originalEventObject = $(this).data('eventObject');
		        var copiedEventObject = $.extend({}, originalEventObject);
		        copiedEventObject.start = date;
		        copiedEventObject.allDay = allDay;
		        $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
		        if ($('#drop-remove').is(':checked')) {
		            $(this).remove();
		        }
		    },
		    events: [
		    	//TODO: Will need to loop through saved even items
		//    	  <c:forEach var='event' items='${myData.events}'>
		//    	    { title: '${event.title}', start: new Date(${event.timestamp}) },
		//    	  </c:forEach>
		//    	  null
		    ]
		});
	});
</script>
<jsp:include page="footer.jsp" />