package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dto.Book;
import com.book.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepo bookRepo;
	
	@Override
	public List<Book> findAllByTitle(String title) {
		// TODO Auto-generated method stub
		return bookRepo.findAllByTitle(title);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		//System.out.print(bookRepo.findAll().get(1));
		return bookRepo.findAll();
	}

	@Override
	public void AddBook(Book book) {
		System.out.println(book);
		System.out.println("initial qty "+book.getQuantity());
		book.setQuantity(book.getQuantity() + 1);
		System.out.println("add called "+book.getQuantity());
		bookRepo.save(book);
	}

	@Override
	public void updateBook(String isbn) {
		
		System.out.println("hey mate");
		Book b = bookRepo.findById(isbn).get();
//		System.out.println(b);
//		System.out.println(isbn);
//		//if()
		b.setQuantity(b.getQuantity() + 1);
////		System.out.println("update called "+b.getQuantity());
		bookRepo.save(b);
	}

	@Override
	public Optional<Book> findById(String isbn) {
		// TODO Auto-generated method stub
		return bookRepo.findById(isbn);
	}
	

}
