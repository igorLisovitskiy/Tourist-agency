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

});

$('#myModal').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus')
})

$(document).ready(function() {
    $('#search-tours').on('click', function(e) {
        e.preventDefault();
        var start = $("#tour-dates input[name='startDate']").val();
        var end = $("#tour-dates input[name='endDate']").val();
        var regexDate = /\d{2}\/\d{2}\/\d{4}/m;

        if(regexDate.test(start) && regexDate.test(end)){
            $('#tours-modal').modal('toggle');

            var table = $("#tours").DataTable({
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
                            return "<a class='details btn btn-info btn-sm'>Details</a>";
                        },
                        "bSortable": false
                    }
                ],
                "columnDefs": [
                    { "width": "5%", "targets": 0 },
                    { "width": "30%", "targets": 2 }
                ],
                "bDestroy": true
            });

        }else{
            regexDate.test(start) ? $("#tour-dates input[name='endDate']").addClass('is-invalid') :  $("#tour-dates input[name='startDate']").addClass('is-invalid');
        };
        $('#tours tbody').on( 'click', 'a', function () {
            var tourId = $("#tours").DataTable().row($(this).closest('tr')).data().tourId;
            var url = "dashboard/tour?id="+ tourId;
            window.open(url, '_blank');
        } );
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
    $('#search-hotels').on('click', function(e) {
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
