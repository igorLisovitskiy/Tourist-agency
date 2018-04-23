$(document).ready(function() {
    $('#birthday').datepicker({
        autoclose: true,
        todayHighlight: true
    });
});
$(document).ready(function() {
    $(".panel-heading").html('<b>All Orders </b><button id="refresh">Refresh</button>');
    $('#refresh').on('click', loadUsers);
    var table = $("#orders").DataTable({
        "responsive" : true,
        "ajax":{
            url: "orders/all",
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
                    return "<button class='edit btn btn-warning btn-sm' data-toggle=\"modal\" data-target=\"#editUserModal\">Edit</button>";
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
        var userId = $("#orders").DataTable().row($(this).closest('tr')).data().id;
        var url = "update/user?id="+ userId + "&edit=true";
        updateUser(url);
    }).on( 'click', '.delete', function () {
        var userId = $("#orders").DataTable().row($(this).closest('tr')).data().id;
        var url = "update/user?id="+ userId+ "&delete=true";
        var deleteUser = confirm("Are you shure you want to delete the user #" + userId + "?");
        if(deleteUser){
            $.ajax({
                url : url,
                type: "DELETE",
                success: function (data) {
                    loadUsers();
                },
                error: function (jXHR, textStatus, errorThrown) {
                    alert(textStatus);
                }
            });
        }
    });


});

function loadUsers(){
    var table = $("#orders").DataTable({
        "responsive" : true,
        "ajax":{
            url: "orders/all",
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
                    return "<button class='edit btn btn-warning btn-sm' data-toggle=\"modal\" data-target=\"#editUserModal\">Edit</button>";
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
    $( "#edit-user-form").on('submit', function(e) {
            $.ajax({
                url : url,
                type: "POST",
                data: $('#edit-user-form').serialize(),
                success: function (data) {
                    loadUsers();
                },
                error: function (jXHR, textStatus, errorThrown) {
                    alert(textStatus);
                }
        });
        e.preventDefault();
        $('#editUserModal').modal('toggle');
    });
}


