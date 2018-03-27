	$(document).ready(function(){
		var date_input=$('input[name="dateOfBirth"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
			format: 'mm/dd/yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true,
			orientation: 'top auto',
		})
	})
	
	// Get the modal
var signUp = document.getElementById('id02');
var login = document.getElementById('id01');
window.onclick = function(event) {
    if (event.target == signUp) {
        signUp.style.display = "none";
    }
	 if (event.target == login) {
        login.style.display = "none";
    }
};

