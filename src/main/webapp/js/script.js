// Get the modal
	$('#sign-up').on('submit', function(e) {
		
		console.log("submit");
	    e.preventDefault();
	    $.ajax({
	    url : "/signing",
	    type: "POST",
	    data: $('#sign-up').serialize(),
	    success: function (data) {
			console.log(data);
	       //$("#schedule").html(data);
	       },
	        error: function (jXHR, textStatus, errorThrown) {
	         alert(errorThrown);
	         }
	     });
	});
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


//$('.signupbtn').click(function(){
	//$.post('/login', $("#sign-up").serialize());
//});




//$.post('/signing', $("#login").serialize());