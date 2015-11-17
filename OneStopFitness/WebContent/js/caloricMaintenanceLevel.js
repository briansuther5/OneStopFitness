var caloricMaintenanceLevel = {
	calculatorFeetBtnSelector : ".feet-btn"
	,calculatorInchesBtnSelector : ".inches-btn"
	,init : function() {
		$(caloricMaintenanceLevel.calculatorFeetBtnSelector).bind("click", function() {
			var selector = caloricMaintenanceLevel.calculatorFeetBtnSelector;
			caloricMaintenanceLevel.highlight($(this), selector);
		});
		$(caloricMaintenanceLevel.calculatorInchesBtnSelector).bind("click", function() {
			var selector = caloricMaintenanceLevel.calculatorInchesBtnSelector;
			caloricMaintenanceLevel.highlight($(this), selector);
		});
	}
	,highlight : function(btnObj, selector) {
		$(selector).each(function() {
			if($(this).hasClass("btn-success")) {
				$(this).removeClass("btn-success");
				$(this).addClass("btn-default");
			}
		});
		btnObj.removeClass("btn-default");
		btnObj.addClass("btn-success");
	}
};
$(document).ready(function() {
	caloricMaintenanceLevel.init();
});