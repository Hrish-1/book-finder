<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src = "js/admin_home.js"></script>
<title>The Book Finder</title>
</head>
<body style="background-color: #7382763b">
	<div class="container-fluid p-0 h-100 overflow-auto" >
	
		<nav class="navbar navbar-expand-lg navbar-light bg-dark">
  		        <a class="navbar-brand text-light" href="#"><b>The Book Finder</b></a>
  
 	        <form class="form-inline my-2 my-lg-0 mx-5 w-75 ">
                <input class="form-control mr-sm-2 w-75" id="search_book" type="text" placeholder="Search" aria-label="Search">
                <button type="button" class="btn btn-outline-success my-2 my-sm-0" id="search_book_btn" onclick="callAjax()">Search</button>
            </form>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link text-light" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown mx-1">
                        <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Login
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="prep_log_form.htm">User Login</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Admin Login</a>
                        </div>
                    </li>
                    <li class="nav-item">
      	                <!-- register.htm -->
                        <a class="nav-link text-light" href="prep_reg_form.htm">Register</a>
                    </li>
                </ul>
    
            </div>
        </nav>

        <div class="row justify-content-center mt-4" id="book">
        </div>
    
        <div class="card-footer text-light bg-dark fixed-bottom d-flex justify-content-center">
            <b>&#169 The Book Finder</b>
          </div>
	</div>
</body>
</html>