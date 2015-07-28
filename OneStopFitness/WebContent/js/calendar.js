var eOneStopFitnessCalendar = {
	initBinding : function() {
		$('.add-event').bind("click", function() {
			var label = '<div class="external-event label label-success ui-draggable" style="position:relative;">'+eOneStopFitnessCalendar.buildNewExerciseLabelHtml()+'</div>';
			$('#external-events').prepend(label);
			var obj = $('#external-events div:first-child');
			eOneStopFitnessCalendar.makeEventObjDraggable(obj);
			$('.new-exercise-name').val('');
			$('.new-exercise-reps').val('');
			$('.new-exercise-sets').val('');
		});
	}
	,buildNewExerciseLabelHtml : function() {
		var exercise = $('.new-exercise-name').val();
		var reps = $('.new-exercise-reps').val();
		var sets = $('.new-exercise-sets').val();
		if(reps == '' && sets != '') {
			return '<span class="exercise-name">'+ exercise + '</span> <span class="hidden-xs">(' + sets + ' sets)</span>';
		} else if(reps == '' && sets == '') {
			return '<span class="exercise-name">' + exercise + '</span>';
		} else if(reps != '' && sets == '') {
			return '<span class="exercise-name">' + exercise + '</span> <span class="hidden-xs">(' + reps + ' reps)</span>';
		} else {
			return '<span class="exercise-name">' + exercise + '</span> <span class="hidden-xs">(' + reps + ' reps, ' + sets + ' sets)</span>';
		}
	}
	,makeEventObjDraggable : function(obj) {
        var eventObject = {
        		title: $.trim(obj.text())
        };
        obj.data('eventObject', eventObject);
        obj.draggable({
            zIndex: 999,
            revert: true,
            revertDuration: 0
        });
	}
};
$(document).ready(function() {
	eOneStopFitnessCalendar.initBinding();
});