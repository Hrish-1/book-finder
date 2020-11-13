package com.book.cntr;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.dto.Book;
import com.book.dto.User;
import com.book.repository.BookRepo;
import com.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	String bk;
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String addBook(Book book) {
		System.out.println(bookService.findById(book.getIsbn()));
		if(bookService.findById(book.getIsbn()).equals(Optional.empty())){
			bookService.AddBook(book);
			return "admin_home";
		}else {
			bookService.updateBook(book.getIsbn());
			return "admin_home";
		}
	}
	@RequestMapping(value = "/getbook", method = RequestMethod.GET)
	public void getBook(@RequestParam String booktitle,HttpServletRequest request){
		
		System.out.println(booktitle);
		List<Book> list = bookService.findAllByTitle(booktitle);
		//System.out.println(li.get(0));
		bk = booktitle;
	}
	@RequestMapping(value = "/user-book-search")
	public String userBookSearch(HttpServletRequest request) {
		List<Book> list = bookService.findAllByTitle(bk);
		request.setAttribute("book",list);
		return "user_search";
	}
	@RequestMapping(value = "/user-buy-book",method = RequestMethod.POST)
	public String userBuyBook(Book book,User user,HttpSession session) {
		System.out.println("hey-----------------------------------------");
		System.out.println("bookTitle"+book.getTitle());
		bookService.bookUserMap(book, user);
		List<Book> book1 = bookService.findAll();
		session.setAttribute("book",book1);
		return "user_home";
	}
	
	@GetMapping("/show-books")
	public String showAllBooks(HttpServletRequest req) {
		req.setAttribute("books",bookService.findAllBookUser());
		req.setAttribute("mode","ALL_USERS_BOOKS");
		return "showAllBooks";
	}
	@GetMapping("/show-all-books")
	public String showAllBookDetails(HttpServletRequest req) {
		req.setAttribute("allbooks",bookService.findAll());
		req.setAttribute("mode","BOOK_DETAILS");
		return "showAllBooks";
	}
	@RequestMapping("/delete-book")
	public String deleteUser(@RequestParam String id, HttpServletRequest request) {
		bookService.deleteMyBook(id);
		request.setAttribute("allbooks",bookService.findAll());
		request.setAttribute("mode", "ALL_BOOKS");
		return "showAllBooks";
	}
	
	@RequestMapping("/edit-book")
	public String editUser(@RequestParam String id,HttpServletRequest request) {
		request.setAttribute("book", bookService.editBook(id));
		request.setAttribute("mode", "BOOK_UPDATE");
		return "showAllBooks";
	}
	@PostMapping("/save-book")
	public String registerUser(@ModelAttribute Book book, BindingResult bindingResult, HttpServletRequest request) {
		bookService.saveMyBook(book);
		request.setAttribute("allbooks",bookService.findAll());
		request.setAttribute("mode", "ALL_BOOKS");
		return "showAllBooks";
	}

}
