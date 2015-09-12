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
	,buildProgram : function(oneRepMax) {
		$("#jwTable").empty();
		var html = '<table class="table table-condensed table-striped">';
		html += '<tr><th></th><th>Week 1</th><th>Week 2</th><th>Week 3</th><th>Week 4</th></tr>';
		html += '<tr>';
		html += '<td><b>Set 1</b></td>';
		html += '<td>' + oneRepMax * .65 + ' x 5</td>';
		html += '<td>' + oneRepMax * .70 + ' x 3</td>';
		html += '<td>' + oneRepMax * .75 + ' x 5</td>';
		html += '<td>' + oneRepMax * .40 + ' x 5</td>';
		html += '</tr><tr>';
		html += '<td><b>Set 2</b></td>';
		html += '<td>' + oneRepMax * .75 + ' x 5</td>';
		html += '<td>' + oneRepMax * .80 + ' x 3</td>';
		html += '<td>' + oneRepMax * .85 + ' x 3</td>';
		html += '<td>' + oneRepMax * .60 + ' x 5</td>';
		html += '</tr><tr>';
		html += '<td><b>Set 3</b></td>';
		html += '<td>' + oneRepMax * .85 + ' x 5+</td>';
		html += '<td>' + oneRepMax * .90 + ' x 3+</td>';
		html += '<td>' + oneRepMax * .95 + ' x 1+</td>';
		html += '<td>' + oneRepMax * .60 + ' x 5</td>';
		html += '</tr></table>';
		$("#jwTable").append(html);
	}
}
$(document).ready(function() {
	jimWendler.init();
});