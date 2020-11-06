package com.book.service;

import java.util.List;
import java.util.Optional;

import com.book.dto.Book;
import com.book.dto.BookUser;
import com.book.dto.User;

public interface BookService {
	
	List<Book> findAllByTitle(String title);
	List<Book> findAll();
	void AddBook(Book book);
	void updateBook(String isbn);
	Optional<Book> findById(String isbn);
	void bookUserMap(Book book,User user);
	List<BookUser> findAllBookUser();
}
