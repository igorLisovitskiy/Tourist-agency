$(document).ready(function() {

        $('.input-daterange').datepicker({
            autoclose: true,
            todayHighlight: true
        });

        $('#tours-modal').on('shown.bs.modal', function () {
            $('#myInput').trigger('focus')
        });

});
$(document).ready(function() {
    loadTours();
});

function loadTours(){
    $("#tours").dataTable().fnDestroy();
    var table = $("#tours").DataTable({
        "ajax":{
            url: "tours/all",
            dataType : "json",
            type: "GET",
            "data": function(d){
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
                    return "<a class='details btn btn-info btn-sm'>Details</a>";
                },
                "bSortable": false
            }
        ],
        "columnDefs": [
            { "width": "5%", "targets": 0 },
            { "width": "30%", "targets": 2 }
        ]
    }).on( 'click', 'a', function () {
        var tourId = $("#tours").DataTable().row($(this).closest('tr')).data().tourId;
        var url = "dashboard/tour?id="+ tourId;
        window.open(url, '_blank');
    });
    $(".panel-heading").html('<b>All Tours </b><button id="refresh">Refresh</button>');
    $('#refresh').on('click', loadTours());
}