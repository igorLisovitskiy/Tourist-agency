$(document).ready(function() {
    var info = document.getElementById('form-info');
    var pass = document.getElementById('form-password');
    window.onclick = function (event) {
        if (event.target == info) {
            info.style.display = "none";
        }
        if (event.target == pass) {
            pass.style.display = "none";
        }
    };

    $('#repeat-password').on('keyup', function () {
        if ($('#new-password').val() == $('#repeat-password').val()) {
            $('.confirm-password').removeClass('has-error');
            $('#signup :input[type="submit"]').prop('disabled', false);
            $('#repeat-password').css("background-color", "#f1f1f1");
            $('#signup :input[type="submit"]').css("background-color", "#75c2f4");
        } else{
            $('#repeat-password').css("background-color", "#ffcccc");
            $('#signup :input[type="submit"]').css("background-color", "#7a7a7a");
            $('#signup :input[type="submit"]').prop('disabled', true);
            $('.confirm-password').addClass('has-error');
        }
    });



$('#myModal').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus')
})

$('#search-tours').on('click', function(e) {
        	e.preventDefault();
            $('#tours-modal').modal('toggle');
            var table = $("#tours").DataTable({
                "ajax":{
                    url: "profile/mytours",
                    dataType : "json",
                    type: "GET",
                    dataSrc:'',
                },
                "columns": [
                    { "data": "name",
                    	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                    			if(oData.tourId != null){
                    				$(nTd).html("<a href='dashboard/tour?id="+oData.tourId+"'>"+oData.name+"</a>");
                    			}
                    	}
                    }
                ],
                "bDestroy": true
            });
});

	$('#search-hotels').on('click', function(e) {
		e.preventDefault();
	    $('#hotels-modal').modal('toggle');
	    var table = $("#hotels").DataTable({
	        "ajax":{
	            url: "profile/myhotels",
	            dataType : "json",
	            type: "GET",
	            dataSrc:'',
	        },
	        "columns": [
	            { "data": "name",
	            	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
	            			if(oData.tourId != null){
	            				$(nTd).html("<a href='dashboard/hotel?id="+oData.hotelId+"'>"+oData.name+"</a>");
	            			}
	            	}
	            }
	        ],
	        "bDestroy": true
	    });
	});
    $('#search-flights').on('click', function(e) {
    	e.preventDefault();
        $('#flights-modal').modal('toggle');
        var table = $("#flights").DataTable({
            "ajax":{
                url: "profile/myflights",
                dataType : "json",
                type: "GET",
                dataSrc:'',
            },
            "columns": [
                { "data": "name",
                	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                			if(oData.tourId != null){
                				$(nTd).html("<a href='dashboard/flight?id="+oData.flightsId+"'>From"+oData.fromCity+" to "+ oData.toCity +"</a>");
                			}
                	}
                }
            ],
            "bDestroy": true
        });
    });
});
