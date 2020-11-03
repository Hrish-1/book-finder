<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>User Registration</title>
</head>
<body>
	<div class = "container-fluid">
	<div class="row" style="height: 100vh">
		<div class="col d-flex justify-content-center align-items-center flex-column">
			<div><h1>Register Here</h1></div>
			<br>
			<form action="login" method = "post">
				<div style="margin-bottom: 10px; width: 25vw">
					<input  class="form-control" name="name" placeholder="Enter your name"/>
				</div>
				<div style="margin-bottom: 10px; width: 25vw">
					<input  class="form-control" name="userName" placeholder="Enter your username"/>
				</div>
				<div style="margin-bottom: 10px; width: 25vw">
					<input type= "password" class="form-control" name = "password" placeholder="Enter your password"/>
				</div>
				<div style="margin-bottom: 10px; width: 25vw">
					<input  class="form-control" name="mail" placeholder="Enter your email"/>
				</div>
				<div style="margin-bottom: 10px; margin-left: 33%">
					<button type="submit" class="btn btn-dark" >REGISTER</button>
				</div>
			</form>
			<a href="#">Already Register? Login</a>
		</div>
	</div>
	</div>
</body>
</html>