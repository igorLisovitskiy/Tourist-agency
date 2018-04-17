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
    <script src="js/userdashboard.js" type="text/javascript"></script>
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
        .card-header{
            font-size: 1.2em;
            color: #FFF;
            background:#293b66;
            padding:10px;
        }

            .card-body{
                padding: 5px;
            }
            .card-btn{
                position: absolute;
                bottom:15px;
                width: 90%;
            }
        .description{
            max-width: 80%;
            display:inline-block;
        }
        .borderless td, .borderless th {
            border: none;
            border-top: 0px !important;
        }
        .borderless{
            width: 20%;
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
                                            data-toggle="dropdown" href="#">Welcome, ${user.username} <i
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
    <!-- /.navbar-collapse -->
</nav>
<!-- Header -->


<!-- Page content -->
<div class="user-content" style="min-height: 200px;">
    <div class="container">
        <h2>${tour.name}</h2>
        <div class="description">
            With our licensed guide get to know all of RomeвЂ™s wonders in a single day, with a rich and fascinating programme lasting 7 hours, including a lunch break. The morning is dedicated to visiting the Vatican Museums. We have access, without queueing, at 8.10 am, before normal public opening hours, after a typical Italian breakfast with cornetto and cappuccino.
            We begin at the Belvedere Terrace, to admire the Dome of St Peter Basilica, then we proceed to see the celebrated LaocoГ¶n and His Sons and the Belvedere Torso.
            We stroll through all the Galleries arriving, finally, in the place painted by Michelangelo, where the Conclave elects a new Pope: the Sistine Chapel. After we make our way directly to
            St PeterвЂ™s Basilica to enjoy the grandeur of the worldвЂ™s most important basilica with its wonders like MichelangeloвЂ™s Pieta.
        </div>
        <div class="card">
            <div class="card-header">
                Book Now:
            </div>
            <div class="card-body">
                <h5 class="card-title">Only From:</h5>
                <p> ${tour.price}</p>
                <a href="#" class=" card-btn btn btn-primary">Book</a>
            </div>
        </div>
        <div class="details">
            <hr>
            <table class="table borderless border-0">

                <tbody>
                <tr>
                    <th scope="row">Start</th>
                    <td>${tour.start}</td>
                </tr>
                <tr>
                    <th scope="row">End</th>
                    <td>${tour.end}</td>
                </tr>
                <tr>
                    <th scope="row">Language</th>
                    <td>${tour.language}</td>
                </tr>
                </tbody>
            </table>
            <hr>
        </div>
    </div>


    </div>
</div>

<!-- Footer -->
<footer class="user-container user-center user-margin-top">
    <h3>Enjoy ${tour.name} sights</h3>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=251" data-toggle="lightbox" data-gallery="example-gallery" class="">
                <img src="https://unsplash.it/600.jpg?image=251" class="col-sm-2">
            </a>
        </div>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=252" data-toggle="lightbox" data-gallery="example-gallery" class="-2">
                <img src="https://unsplash.it/600.jpg?image=252" class="col-sm-2">
            </a>
        </div>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=253" data-toggle="lightbox" data-gallery="example-gallery" class="">
                <img src="https://unsplash.it/600.jpg?image=253" class="col-sm-2">
            </a>
        </div>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=254" data-toggle="lightbox" data-gallery="example-gallery" class="">
                <img src="https://unsplash.it/600.jpg?image=254" class="col-sm-2">
            </a>
        </div>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=255" data-toggle="lightbox" data-gallery="example-gallery" class="">
                <img src="https://unsplash.it/600.jpg?image=255" class="col-sm-2">
            </a>
        </div>
        <div class="col">
            <a href="https://unsplash.it/1200/768.jpg?image=256" data-toggle="lightbox" data-gallery="example-gallery" class="">
                <img src="https://unsplash.it/600.jpg?image=256" class="col-sm-2">
            </a>
        </div>
    </footer>
<script>
    $(document).on('click', '[data-toggle="lightbox"]', function(event) {
        event.preventDefault();
        $(this).ekkoLightbox();
    });
    </script>
</body>
</html>