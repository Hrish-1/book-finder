package com.book.cntr;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.dto.Book;
import com.book.repository.BookRepo;

@Controller
public class BookController {
	
	@Autowired
	BookRepo bookRepo;
	@Autowired
	EntityManager em;
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public void addBook(Book book) {
		bookRepo.save(book);
		System.out.println("record added");
		System.out.println("book title "+book.getTitle());
		System.out.println("book isbn "+book.getIsbn());
	}
	@RequestMapping(value = "/getbook", method = RequestMethod.GET)
	public void getBook(@RequestParam String booktitle){
		
		System.out.println(booktitle);
	List<Book> li = bookRepo.findAllByTitle(booktitle);
	System.out.println(li.get(0));
//		List<Book> l = bookRepo.findAll();
//		bookRepo.findAll();
//		System.out.print(l.get(0));
	}
}
