var caloricMaintenanceLevel = {
	calculatorFeetBtnSelector : ".feet-btn"
	,calculatorInchesBtnSelector : ".inches-btn"
	,calorieMaintenanceLevelDisplaySelector : "#calorie-maintenance-level-display"
	,init : function() {
		$(caloricMaintenanceLevel.calculatorFeetBtnSelector).bind("click", function() {
			var selector = caloricMaintenanceLevel.calculatorFeetBtnSelector;
			caloricMaintenanceLevel.highlight($(this), selector);
		});
		$(caloricMaintenanceLevel.calculatorInchesBtnSelector).bind("click", function() {
			var selector = caloricMaintenanceLevel.calculatorInchesBtnSelector;
			caloricMaintenanceLevel.highlight($(this), selector);
		});
		$("#calculateBtn").bind("click", function() {
			caloricMaintenanceLevel.calorieMaintenanceEstimation();
		});
	}
	,calorieMaintenanceEstimation : function() {
		var gender = $("#gender").val();
		var feet = parseInt($(".feet-btn.btn-success").attr("id"));
		var inches = parseInt($(".inches-btn.btn-success").attr("id"));
		var age = parseInt($("#age").val());
		var weight = parseInt($("#weight").val());
		var activityLevel = parseFloat($("#activityLevel").val());
		if(gender == "M") {
			var calories = caloricMaintenanceLevel.mifflinStJeorFormulaMan(weight / 2.2, ((feet * 12) + inches) * 2.54, age, activityLevel);
			$(caloricMaintenanceLevel.calorieMaintenanceLevelDisplaySelector).empty();
			$(caloricMaintenanceLevel.calorieMaintenanceLevelDisplaySelector).html("Your current estimated caloric maintenance level is <span style='color:#029a02;font-weight:bold;font-size:25px;'>" + Math.round(calories) + "</span> calories.");
			$(caloricMaintenanceLevel.calorieMaintenanceLevelDisplaySelector).show();
		} else {
			var calories = caloricMaintenanceLevel.mifflinStJeorFormulaWoman(weight / 2.2, ((feet * 12) + inches) * 2.54, age, activityLevel);
			alert(calories);
		}
	}
	,mifflinStJeorFormulaMan : function(weight, height, age, activityLevel) {
		return (10 * weight + 6.25 * height - 5 * age + 5) * activityLevel;
	}
	,mifflinStJeorFormulaWoman : function(weight, height, age) {
		return (10 * weight + 6.25 * height - 5 * age - 161) * activityLevel;
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