/**
 * 
 */

//let getBook = async () => {
//	var bookTitle = document.getElementById("search_book").value;
//	console.log(bookTitle);
//	let url = `http://localhost:8080/getbook?booktitle=${bookTitle}`;
//	await fetch(url);
//} 

let getBook = function () {
    let xhr = new XMLHttpRequest();
  
    // document.querySelector("#book_1").innerHTML="";
    // document.querySelector("#book_2").innerHTML="";
    var bookTitle = document.querySelector('#search_book').value;
    console.log(bookTitle);
    // response is ready :: 4
    xhr.onload = () => {
      const refJson = JSON.parse(xhr.responseText);
      // using this data :: we have to DOM Operation;
//      findBook();
    };
  
    xhr.open("GET", "http://localhost:8080/getbook?booktitle="+bookTitle);
    xhr.send();
  };
  
//let findBook = () => {
//	
//	document.querySelector("#book-1").innerHTML = htmlCard();
//} 
//let htmlCard = () => {
//	
//	var bookHtml = `
//          <%for(Book b : bkname){ %>
//	        <div class="col-6 p-2">
//	        <div class="card" style="">
//	        <div class="row">
//	            <div class="col-4">
//	            <img src=<%=b.getImg()%> class="card-img" alt="...">
//	            </div>
//	            <div class="col-8">
//	            <div class="card-body">
//	                <h5 class="card-title"><%=b.getTitle() %></h5>
//	                <p class="card-text">Author : <%=b.getAuthor() %></p>
//	                <p class="card-text">Language : <%=b.getLang() %></p>
//	                <p class="card-text">Rating : <%=b.getRating() %></p>
//					<button class = "btn btn-secondary">Buy Book</button>
//	            </div>
//	            </div>
//	        </div>
//	        </div>
//	        </div>
//	        <% }%>
//	        `
//    return bookHtml;
//}
  
 let userBuy = async() => {
	 
 	
 	let isbn = document.querySelector("#isbn").value;
 	let title = document.querySelector("#title").value;
 	let author = document.querySelector("#author").value;
 	let img = document.querySelector("#img").value;
 	let rating = document.querySelector("#rating").value;
 	let lang = document.querySelector("#lang").value;
 	let quantity = document.querySelector("#quantity").value;
 	let status = document.querySelector("#status").value;
 	let userName = document.querySelector("#userName").value;
 	let id = document.querySelector("#id").value;
 	
	 const input = {
		      isbn: isbn,
		      title: title,
		      author: author,
		      img: img,
		      rating: rating,
		      lang: lang,
		      quantity: quantity,
		      status: status,
		      userName: userName,
		      id: id
		    };
	 
	 const url = "http://localhost:8080/user-buy-book";
	 console.log("-----------hey-----------");
	 
	 await fetch(url, {
	      method: "POST",
	      body: JSON.stringify(input),
	      headers: {
	        "Content-Type": "application/json"
	      }
	 });

 };