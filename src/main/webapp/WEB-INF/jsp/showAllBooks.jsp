<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</head>
<body>
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
                            <a class="dropdown-item" href="show-users">Show Users</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="show-books">Show Purchases</a>
                             <div class="dropdown-divider"></div>
                             <a class="dropdown-item" href="show-all-books">Show Books</a>
                        </div>
                    </li>
                    <li class="nav-item">
      	                <!-- register.htm -->
                        <a class="nav-link text-light" href="admin-logout">Logout</a>
                    </li>
                </ul>
    
            </div>
   </nav>
<c:choose>
	<c:when test="${mode=='ALL_USERS_BOOKS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>All BOOKS</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>BOOK TITLE</th>
								<th>BOOKS BOUGHT</th>
								<th>USERNAME</th>
								<th>ISBN</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${books }">
								<tr>
									<td>${book.id}</td>
									<td>${book.bookTitle}</td>
									<td>${book.booksBought}</td>
									<td>${book.userName}</td>
									<td>${book.book.getIsbn()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
			<c:when test="${mode=='BOOK_DETAILS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>All BOOKS</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>ISBN</th>
								<th>BOOK TITLE</th>
								<th>AUTHOR</th>
								<th>QUANTITY</th>
								<th>STATUS</th>
								<th>DELETE</th>
								<th>EDIT</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${allbooks}">
								<tr>
									<td>${book.isbn}</td>
									<td>${book.title}</td>
									<td>${book.author}</td>
									<td>${book.quantity}</td>
									<td>${book.status}</td>
									<td><a href="/delete-book?id=${book.isbn}"><span
											class="btn btn-danger">delete</span></a></td>
									<td><a href="/edit-book?id=${book.isbn}"><span
											class="btn btn-success">edit</span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	
	</c:when>
	<c:when test="${mode=='BOOK_UPDATE'}">
			<div class="container text-center 
				 d-flex flex-column align-items-center justify-content-center">
				<h3 class = "my-3">Update Book</h3>
				<form class = "w-50 d-flex flex-column align-items-center" method="POST" action="save-book">
					<input type="hidden" name="id" value="${book.isbn }" />
							<input type="text" class="form-control w-50 my-2" name="name"
								value="${book.title}" />
					
							<input type="text" class="form-control w-50 my-2" name="mail"
								value="${book.author}" />
											
							<input type="text" class="form-control w-50 my-2" name="password"
								value="${book.quantity}" />
				
						<input type="submit" class="btn btn-primary my-2" value="Update" />
				</form>
			</div>
		</c:when>
	
</c:choose>
</body>
</html>