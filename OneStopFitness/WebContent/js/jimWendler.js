var jimWendler = {
	jwOneRepMaxSelector : "#jwOneRepMax"
	,jwOneRepMaxButtonSelector : "#jwOneRepMaxButton"
	,jwOneRepMaxAlertSelector : "#jwOneRepMaxAlert"
	,init : function() {
		$(jimWendler.jwOneRepMaxButtonSelector).bind("click", function() {
			var oneRepMax = $(jimWendler.jwOneRepMaxSelector).val();
			if(oneRepMax < 1 || oneRepMax > 1200) {
				$(jimWendler.jwOneRepMaxAlertSelector).show();
			} else {
				$(jimWendler.jwOneRepMaxAlertSelector).hide();
				jimWendler.buildProgram(oneRepMax);
			}
		});
	}
	,computeRoundedWeight : function(oneRepMax, percent) {
		return Math.round((oneRepMax * percent) * 10) / 10;
	}
	,buildProgram : function(oneRepMax) {
		$("#jwTable").empty();
		var html = '<table class="table table-condensed table-striped">';
		html += '<tr><th></th><th>Week 1</th><th>Week 2</th><th>Week 3</th><th>Week 4</th></tr>';
		html += '<tr>';
		html += '<td><b>Set 1</b></td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .65) + 'lbs x 5 reps</td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .70) + 'lbs x 3 reps</td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .75) + 'lbs x 5 reps</td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .40) + 'lbs x 5 reps</td>';
		html += '</tr><tr>';
		html += '<td><b>Set 2</b></td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .75) + 'lbs x 5 reps</td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .80) + 'lbs x 3 reps</td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .85) + 'lbs x 3 reps</td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .60) + 'lbs x 5 reps</td>';
		html += '</tr><tr>';
		html += '<td><b>Set 3</b></td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .85) + 'lbs x 5+ reps</td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .90) + 'lbs x 3+ reps</td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .95) + 'lbs x 1+ reps</td>';
		html += '<td>' + jimWendler.computeRoundedWeight(oneRepMax, .60) + 'lbs x 5 reps</td>';
		html += '</tr></table>';
		$("#jwTable").append(html);
	}
}
$(document).ready(function() {
	jimWendler.init();
});