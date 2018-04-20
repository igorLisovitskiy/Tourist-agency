$(document).ready(function() {
    $('#birthday').datepicker({
        autoclose: true,
        todayHighlight: true
    });
        $('#tours-modal').on('shown.bs.modal', function () {
            $('#myInput').trigger('focus');
        });

    $('#editUserModal').on('hidden.bs.modal', function () {
        $('.modal-header').find('h4').remove();
        $('#edit-user-form').off('submit');
    });

    $( "#create-user-form").on('submit', function(e) {
        $.ajax({
            url : 'create/user?create=true',
            type: "POST",
            data: $('#create-user-form').serialize(),
            success: function (data) {
                $("#alert-area").append($("<div class=\"alert alert-success alert-dismissible fade in\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>Success!</strong> User Added!.</div>"));
                $(".alert-success").delay(2000).fadeOut("slow", function () { $(this).remove(); });
                loadUsers();
            },
            error: function (jXHR, textStatus, errorThrown) {
                alert(textStatus);
            }
        });
        e.preventDefault();
    });
});
$(document).ready(function() {
    $(".panel-heading").html('<b>All Users </b><button id="refresh">Refresh</button>');
    $('#refresh').on('click', loadUsers);
    var table = $("#users").DataTable({
        "responsive" : true,
        "ajax":{
            url: "users/all",
            dataType : "json",
            type: "GET",
            "data": function(d){
            },
            dataSrc:'',
        },
        "columns": [
            { "data": "id"},
            { "data": "username"},
            { "data": "password"},
            { "data": "mail"},
            { "data": "birthday"},
            { "data": "role"},
            {
                "data": function(data, type) {
                    return "<button class='edit btn btn-warning btn-sm' data-toggle=\"modal\" data-target=\"#editTourModal\">Edit</button>";
                },
                "bSortable": false
            },
            {
                "data": function(data, type) {
                    return "<button class='delete btn btn-danger btn-sm'>Delete</button>";
                },
                "bSortable": false
            }
        ],
        "bDestroy": true

    }).on( 'click', '.edit', function () {
        var userId = $("#users").DataTable().row($(this).closest('tr')).data().userId;
        var url = "update/user?id="+ userId + "&edit=true";
        updateUser(url);
    }).on( 'click', '.delete', function () {
        var userId = $("#users").DataTable().row($(this).closest('tr')).data().userId;
        var url = "update/user?id="+ userId+ "&delete=true";
        var deleteUser = confirm("Are you shure you want to delete the user #" + userId + "?");
        if(deleteUser){
            $.ajax({
                url : url,
                type: "DELETE",
                success: function (data) {
                    loadTours();
                },
                error: function (jXHR, textStatus, errorThrown) {
                    alert(textStatus);
                }
            });
        }
    });


});

function loadUsers(){
    var table = $("#users").DataTable({
        "responsive" : true,
        "ajax":{
            url: "users/all",
            dataType : "json",
            type: "GET",
            "data": function(d){
            },
            dataSrc:'',
        },
        "columns": [
            { "data": "id"},
            { "data": "username"},
            { "data": "password"},
            { "data": "mail"},
            { "data": "birthday"},
            { "data": "role"},
            {
                "data": function(data, type) {
                    return "<button class='edit btn btn-warning btn-sm' data-toggle=\"modal\" data-target=\"#editTourModal\">Edit</button>";
                },
                "bSortable": false
            },
            {
                "data": function(data, type) {
                    return "<button class='delete btn btn-danger btn-sm'>Delete</button>";
                },
                "bSortable": false
            }
        ],
        "bDestroy": true
    });
}


$('#editUserModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);
    var recipient = button.data('whatever');
    var modal = $(this);
    modal.find('.modal-title').text('New message to ' + recipient);
    modal.find('.modal-body input').val(recipient);
});

function updateUser(url){
    $( "#edit-tour-form").on('submit', function(e) {
            $.ajax({
                url : url,
                type: "POST",
                data: $('#edit-user-form').serialize(),
                success: function (data) {
                    loadTours();
                },
                error: function (jXHR, textStatus, errorThrown) {
                    alert(textStatus);
                }
        });
        e.preventDefault();
        $('#editUserModal').modal('toggle');
    });
}


