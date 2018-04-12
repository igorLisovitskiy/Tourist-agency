// Tabs

function openLink(evt, linkName) {
    var i, x, tablinks;
    x = document.getElementsByClassName("myLink");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < x.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" user-red", "");
    }
    document.getElementById(linkName).style.display = "block";
    evt.currentTarget.className += " user-red";
}
$(document).ready(function() {
    document.getElementsByClassName("tablink")[0].click();
});
/*
$(document).ready(function() {
// Click on the first tablink on load
document.getElementsByClassName("tablink")[0].click();

$('.input-daterange input').each(function() {
	 var date = new Date("2013-07-15");
    $(this).datepicker({
        maxDate: date,
        dateFormat: "mm.dd.yy"
    });

});
});

$('#sandbox-container .input-daterange').datepicker({
    autoclose: true,
    todayHighlight: true
});
*/

$(document).ready(function() {
	$('#search-tours').on('click', function(e) {
        e.preventDefault();
	    var start = $("#tour-dates input[name='startDate']").val();
        var end = $("#tour-dates input[name='endDate']").val();
        var regexDate = /\d{2}\/\d{2}\/\d{4}/m;

        if(regexDate.test(start) && regexDate.test(end)){
            $('#tours-modal').modal('toggle');

        $("#tours").DataTable({
            "ajax":{
                url: "tours",
                dataType : "json",
                type: "GET",
                "data": function(d){
                    d.startDate = start
                    d.endDate = end
                },
                dataSrc:'',
            },
            "columns": [
                { "data": "tourId"},
                { "data": "name"},
                { "data": "description"},
                { "data": "start"},
                { "data": "end"},
                { "data": "price"},
                { "data": "language"},
                {
                    "data": function(data, type) {
                        return "<a class='btn btn-info btn-sm'>Edit</a>";
                    }
                }
            ],
            "bDestroy": true
        });

        }else{
            regexDate.test(start) ? $("#tour-dates input[name='endDate']").addClass('is-invalid') :  $("#tour-dates input[name='startDate']").addClass('is-invalid');
        }
	});

    $('#search-flights').on('click', function(e) {
        e.preventDefault();
        var start = $("#tour-dates input[name='startDate']").val();
        var end = $("#tour-dates input[name='endDate']").val();
        var regexDate = /\d{2}\/\d{2}\/\d{4}/m;

        if(regexDate.test(start) && regexDate.test(end)){
            $('#tours-modal').modal('toggle');

            $("#tours").DataTable({
                "ajax":{
                    url: "tours",
                    dataType : "json",
                    type: "GET",
                    "data": function(d){
                        d.startDate = start
                        d.endDate = end
                    },
                    dataSrc:'',
                },
                "columns": [
                    { "data": "tourId"},
                    { "data": "name"},
                    { "data": "description"},
                    { "data": "start"},
                    { "data": "end"},
                    { "data": "price"},
                    { "data": "language"},
                    {
                        "data": function(data, type, full) {
                            return '<a class="btn btn-info btn-sm" href=#/' + full[0] + '>' + 'Edit' + '</a>';
                        }
                    }
                ],
                "columnDefs": [
                    { "width": "5%", "targets": 0 },
                    { "width": "20%", "targets": 2 }
                ],
                "bDestroy": true

            });
        } else{
            regexDate.test(start) ? $("#tour-dates input[name='endDate']").addClass('is-invalid') :  $("#tour-dates input[name='startDate']").addClass('is-invalid');
        }
    });
});

$(document).ready(function() {
    $('.input-daterange').datepicker({
        autoclose: true,
        todayHighlight: true
    });
    $('#tours-modal').on('shown.bs.modal', function () {
        $('#myInput').trigger('focus')
    });
});
