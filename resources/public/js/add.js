// prepare the form when the DOM is ready 
$(document).ready(
		function() {
			// bind form using ajaxForm
			$('#addDog').ajaxForm({
				// dataType identifies the expected content type of the server response
				dataType:  'json', 
				// success identifies the function to invoke when the server response 
				// has been received
				success:   processJson 
			});
		}); 
function processJson(data) {
	// 'data' is the json object returned from the server 
	if(data.response){
		$('#errorDiv').hide();
		$('#messageDiv').show();
		$('#messageDiv').html("Dog added!").attr("class","success").delay(1500).fadeOut(1000);
		$('.unselect-field').each(function(){ $(this).removeAttr('checked'); });
		$('.clear-field').each(function(){ $(this).val('');});
       	} else {
		$('#messageDiv').hide();
		$('#errorHR').hide();
		$('#errorDiv').show();
		$('#errorDiv').html("Not possible to add dog, error:" + data.message).attr("class","error");
	}
}
