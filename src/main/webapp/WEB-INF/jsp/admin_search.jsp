<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import = "com.book.dto.Book" %>
<%
	List<Book> book = (List<Book>)session.getAttribute("AllBooks");
	String uname = (String)session.getAttribute("uname");
	int uid = (int)session.getAttribute("uid");
	String pass = (String)session.getAttribute("pass");
	String name = (String)session.getAttribute("name");
	String mail = (String)session.getAttribute("mail");
%>
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
	<div class="container-fluid p-0 h-100" >
	
		<nav class="navbar navbar-expand-lg navbar-light bg-dark">
  		        <a class="navbar-brand text-light" href="#"><b>The Book Finder</b></a>
 	        <form class="form-inline my-2 my-lg-0 mx-5 w-75 ">
                <input class="form-control mr-sm-2 w-75" id="search_book" type="text" placeholder="Search" aria-label="Search">    
                <a href = "user-book-search"><button type="button" class="btn btn-outline-success my-2 my-sm-0" id="search_book_btn" onclick = "callAjax()">Search</button></a>
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
                            <%= uname %>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="prep_log_form.htm">User Login</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Admin Login</a>
                        </div>
                    </li>
                    <li class="nav-item">
      	                <!-- register.htm -->
                        <a class="nav-link text-light" href="user-logout">Logout</a>
                    </li>
                </ul>
    
            </div>
        </nav>
	     <div class = "row justify-content-center" id = "book-container">
	     
	     <div class="row justify-content-between mt-4" id="book" style = "width : 90vw;">
          <%for(Book b : book){ %>
	        <div class="col-6 p-2">
	        <div class="card" style="">
	        <div class="row">
	            <div class="col-4">
	            <img src=<%=b.getImg()%> class="card-img" alt="...">
	            </div>
	            <div class="col-8">
	            <div class="card-body">
	                <h5 class="card-title"><%=b.getTitle() %></h5>
	                <p class="card-text">Author : <%=b.getAuthor() %></p>
	                <p class="card-text">Language : <%=b.getLang() %></p>
	                <p class="card-text">Rating : <%=b.getRating() %></p>
	                <p class="card-text">Status : <%=b.getStatus() %></p>
	                <form action = "addbook" method = "post">
						<input type = "hidden" id = "isbn" name = "isbn" value = "<%=b.getIsbn() %>">
					 	<input type = "hidden" id = "title" name = "title" value = "<%=b.getTitle() %>">
					 	<input type = "hidden" id = "author" name = "author" value = "<%=b.getAuthor() %>">
					 	<input type = "hidden" id = "img"  name = "img" value = "<%=b.getImg() %>">
					 	<input type = "hidden" id = "rating" name = "rating" value = "<%=b.getRating() %>">
					 	<input type = "hidden" id = "lang" name = "lang" value = "<%=b.getLang() %>">
					 	<input type = "hidden" id = "quantity" name = "quantity" value = "<%=b.getQuantity()%>">
					 	<input type = "hidden" id = "status" name = "status" value = "<%=b.getStatus()%>">
					    <button class = "btn btn-secondary" type = "submit">Add Book</button>
	                </form>
	            </div>
	            </div>
	        </div>
	        </div>
	        </div>
	        <% }%>
	        </div>
	     </div> 
        <div class="card-footer text-light bg-dark d-flex justify-content-center">
            <b>&#169 The Book Finder</b>
          </div> 
	</div>
</body>
</html>