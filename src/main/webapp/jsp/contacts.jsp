<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <title>Contacts</title>
   <head>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="css/userpage.css">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
      <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <style>
         body, h1, h2, h3, h4, h5, h6 {
         font-family: normal_text;
         }
         #contacts-form {
         margin-top: 3vh;
         }
         #contacts {
         max-width: 45vh;
         margin-left: 5vh;
         margin-top: 3%;
         }
         #newsletter{
         max-width: 80%;
         margin-left: 5vh;
         }
      </style>
   </head>
   <body class="user-light-grey">
      <nav class="navbar navbar-default navbar-fixed-top">
         <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
               <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                  data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
               <span class="sr-only">Toggle navigation</span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               </button>
               <a class="navbar-brand" href="#">++ProTravel</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
               <ul class="nav navbar-nav navbar-right">
                  <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                        aria-expanded="false">Dropdown <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                     </ul>
                  </li>
                  <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome, User <b
                        class="caret"></b></a>
                     <ul class="dropdown-menu">
                        <li><a href="/user/preferences"><i class="icon-cog"></i> Preferences</a></li>
                        <li><a href="/help/support"><i class="icon-envelope"></i> Contact Support</a></li>
                        <li class="divider"></li>
                        <li><a href="/auth/logout"><i class="icon-off"></i> Logout</a></li>
                     </ul>
               </ul>
            </div>
         </div>
         <!-- /.navbar-collapse -->
         </div><!-- /.container-fluid -->
      </nav>
      <div class="user-container" id="contacts">
         <h2>Contacts</h2>
         <p>Let us book your next trip!</p>
         <i class="fa fa-map-marker" style="width:30px"></i> Chicago, US<br>
         <i class="fa fa-phone" style="width:30px"></i> Phone: +00 151515<br>
         <i class="fa fa-envelope" style="width:30px"> </i> Email: mail@mail.com<br>
         <form action="/action_page.php" target="_blank" id="contacts-form">
            <p><input class="user-input user-padding-16 user-border" type="text" placeholder="Name" required
               name="Name"></p>
            <p><input class="user-input user-padding-16 user-border" type="text" placeholder="Email" required
               name="Email"></p>
            <p><input class="user-input user-padding-16 user-border" type="text" placeholder="Message" required
               name="Message"></p>
            <p>
               <button class="user-button user-black user-padding-large" type="submit">SEND MESSAGE</button>
            </p>
         </form>
      </div>
      <!-- End page content -->
      </div>
      <!-- Newsletter -->
      <div class="user-container" id="newsletter">
         <div class="user-panel user-padding-16 user-black user-opacity user-card user-hover-opacity-off">
            <h2>Get the best offers first!</h2>
            <p>Join our newsletter.</p>
            <label>E-mail</label>
            <input class="user-input user-border" type="text" placeholder="Your Email address">
            <button type="button" class="user-button user-red user-margin-top">Subscribe</button>
         </div>
      </div>
      <!-- End page content -->
      </div>
      <!-- Footer -->
      <footer class="user-container user-center user-opacity user-margin-bottom">
      </footer>
   </body>
</html>