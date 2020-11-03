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
    };
  
    xhr.open("GET", "http://localhost:8080/getbook?booktitle="+bookTitle);
    xhr.send();
  };

