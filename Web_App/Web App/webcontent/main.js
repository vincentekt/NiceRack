$(document).ready(function(){
	$("#open_cabinet_button").click(function(){
		var row_value = $('#row_value').val();
		var column_value = $('#column_value').val();
		var otp_value = $('#otp_value').val();
		
		if ((row_value == "R2") && (column_value == "C1") && (otp_value == "3368")){
			$("#razer_hammerhead_pro_earphones").css("opacity", "1");
		} else if ((row_value == "R3") && (column_value == "C3") && (otp_value == "1586")) {
			$("#book").css("opacity", "1");
		} else {
			alert("You insert the wrong row, column, or OTP value.");
		}
	});
	
	$("#razer_hammerhead_pro_earphones").click(function(){
		var opacity_val = $(this).css("opacity")
		
		if (opacity_val == 1){
			$("#razer_hammerhead_pro_earphones").css("opacity", "0");
		}
	});
	
	$("#book").click(function(){
		var opacity_val = $(this).css("opacity")
		
		if (opacity_val == 1){
			$("#book").css("opacity", "0");
		}
	});
});