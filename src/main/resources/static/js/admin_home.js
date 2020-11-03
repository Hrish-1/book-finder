
let callAjax = function () {
    let xhr = new XMLHttpRequest();
  
    // document.querySelector("#book_1").innerHTML="";
    // document.querySelector("#book_2").innerHTML="";
    document.querySelector('#book').innerHTML = "";
    var search1 = document.querySelector("#search_book").value;
    console.log(search1);
    document.querySelector("#search_book").value="";
    // response is ready :: 4
    xhr.onload = () => {
      const refJson = JSON.parse(xhr.responseText);
      // using this data :: we have to DOM Operation;
      book_display(refJson);
      console.log(refJson);
    };
  
    xhr.open("GET", "https://www.googleapis.com/books/v1/volumes?q="+search1);
    xhr.send();
  };

 let book_display = function(refJson) {
     for(var i=0; i< 8; i+=2)
     {
        var booktitle = refJson.items[i].volumeInfo.title;
        var authorname = refJson.items[i].volumeInfo.authors;
        var preview = refJson.items[i].volumeInfo.previewLink;
        var img = refJson.items[i].volumeInfo.imageLinks.thumbnail;
        var rating = refJson.items[i].volumeInfo.averageRating;
        var lang = refJson.items[i].volumeInfo.language;
        var isbn = refJson.items[i].volumeInfo.industryIdentifiers[0].identifier;
        
        var booktitle1 = refJson.items[i+1].volumeInfo.title;
        var authorname1 = refJson.items[i+1].volumeInfo.authors;
        var preview1 = refJson.items[i+1].volumeInfo.previewLink;
        var img1 = refJson.items[i+1].volumeInfo.imageLinks.thumbnail;
        var rating1 = refJson.items[i+1].volumeInfo.averageRating;
        var lang1 = refJson.items[i+1].volumeInfo.language;
        var isbn1 = refJson.items[i+1].volumeInfo.industryIdentifiers[0].identifier;

        document.querySelector("#book").innerHTML +=  insertVal(booktitle, authorname,preview,img,rating,lang,isbn)+
                                                    insertVal(booktitle1, authorname1,preview1,img1,rating1,lang1,isbn1);

     }
 }
 
 let insertVal =  function(booktitle, authorname,preview,img,rating,lang,isbn)
 {

        var htmlCard = `<div class="col-5 p-2">
        <div class="card" style="">
        <div class="row">
            <div class="col-4">
            <img src="${img}" class="card-img" alt="...">
            </div>
            <div class="col-8">
            <div class="card-body">
                <h5 class="card-title">${booktitle}</h5>
                <p class="card-text">Author: ${authorname}</p>
                <p class="card-text">Publisher: ${lang}</p>
                <p class="card-text">Rating: ${rating}</p>
                <p class="card-text">Isbn: ${isbn}</p>
                <form action = "addbook" method = "post">
                	<input type = "hidden" name = "title" value = "${booktitle}">
                	<input type = "hidden" name = "isbn" value = "${isbn}">
                	<input type = "hidden" name = "img" value = "${img}">
                	<input type = "hidden" name = "rating" value = "${rating}">
                	<input type = "hidden" name = "lang" value = "${lang}">
                	<input type = "hidden" name = "author" value = "${authorname}">
                	<button type = "submit" class = "btn btn-secondary">Add book</button>
                </form>
            </div>
            </div>
        </div>
        </div>
        </div>`

        return htmlCard;
}

//document.querySelector("#search_book").value="";