<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<title>++ProTravel - ${user.mail}</title>
<head>
    <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/userprofile.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/userdashboard.css">

    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.min.js"></script>



    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css">
    <style>
        .card{
            height: 170px;
            float: right;
            position: relative;
            border: #d9d9d9 solid 1px;
            -moz-border-radius-topright:10px;
            -moz-border-radius-topleft:10px;
            -webkit-border-top-right-radius:10px;
            -webkit-border-top-left-radius:10px;
            border-top-left-radius:10px;
            border-top-right-radius:10px;
        }

        .borderless td, .borderless th {
            border: none;
            border-top: 0px !important;
        }
        .menu{

            width: 50%;
            display:inline-block;
        }
        .list-group-item{
            height: 70px;
            font-size: 1.5em;
        }
        .personal-info{

        }
        </style>
</head>
<body class="user-light-grey">
<nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">++ProTravel</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="adminpanel" aria-haspopup="true"
                       aria-expanded="false"><i class="fa fa-dashboard fa-fw"></i>
                    Site Administration</a></li>

                <li><a href="contacts" aria-haspopup="true"
                       aria-expanded="false"><i class="fa fa-envelope fa-fw"></i>
                    Contact us</a></li>

                    <li class="dropdown"><a class="dropdown-toggle"
                                            data-toggle="dropdown" href="#"><i
                            class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="profile"><i class="fa fa-user fa-fw"></i> User
                                Profile</a></li>
                            <li><a href="#"><i class="fa fa-gear fa-fw"></i>
                                Settings</a></li>
                            <li class="divider"></li>
                            <li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
                                Logout</a></li>
                        </ul></li>
            </ul>
        </div>
    </div>
</nav>
<!-- Page content -->
<div class="user-content" style="min-height: 200px;">
    <div class="container">
        <h2>${user.username} account</h2>
    <br>
            <div class="list-group menu">
                <a href="#" class="list-group-item list-group-item-action"><i class="fa fa-globe"></i> Tours</a>
                <a href="#" class="list-group-item list-group-item-action"><i class="fa fa-plane"></i> Flights</a>
                <a href="#" class="list-group-item list-group-item-action"><i class="fa fa-building"></i> Hotels</a>
            </div>
            <div class="personal-info">
                <h3>Personal Information</h3>
                <table class="table borderless border-0">
                    <tbody class="col-md-2">
                    <tr>
                        <th scope="row">Name:</th>
                        <td >${user.username}</td>
                    </tr>
                    <tr>
                        <th scope="row">E-mail:</th>
                        <td  >${user.mail}</td>
                    </tr>
                    <tr>
                        <th scope="row">Birthday:</th>
                        <td >${user.birthday}</td>
                    </tr>
                    </tbody>
                </table>
                <button type="button" class="btn btn-info" id="edit-info">
                    <span class="glyphicon glyphicon-pencil"></span> Edit Information
                </button>
                <button type="button" class="btn btn-success btn-l" id="edit-pass">
                    <span class="glyphicon glyphicon-lock"></span> Change Password
                </button>
            </div>
        </div>
    </div>
</div>
<!-- Footer -->
<footer class="user-container user-center user-margin-top">
  
    </footer>
<script>
    $(document).on('click', '[data-toggle="lightbox"]', function(event) {
        event.preventDefault();
        $(this).ekkoLightbox();
    });
    </script>
</body>
</html>