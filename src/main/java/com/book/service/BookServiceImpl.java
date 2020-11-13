package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dto.Book;
import com.book.dto.BookUser;
import com.book.dto.User;
import com.book.repository.BookRepo;
import com.book.repository.BookUserRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepo bookRepo;
	@Autowired
	BookUserRepo bookUserRepo;
	
	
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
		book.setStatus("available");
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
		b.setStatus("available");
////		System.out.println("update called "+b.getQuantity());
		bookRepo.save(b);
	}

	@Override
	public Optional<Book> findById(String isbn) {
		// TODO Auto-generated method stub
		return bookRepo.findById(isbn);
	}

	@Override
	public void bookUserMap(Book book, User user) {
		
		//Optional<BookUser> b = bookUserRepo.findByBookId(book.getIsbn());
		System.out.println("book title "+book.getTitle());
		System.out.println("book isbn "+book.getIsbn());
		System.out.println("author "+book.getAuthor());
		//System.out.println("Author "+b.get().getBook().getAuthor());
		System.out.println("UserId "+user.getId());
		System.out.println("UserName "+user.getUserName());
		System.out.println(bookUserRepo.getId(book.getIsbn(),user.getId()));
		System.out.println("book status "+book.getStatus());
		System.out.println("quantity "+book.getQuantity());
		Integer x = bookUserRepo.getId(book.getIsbn(),user.getId());
		if(x == null) {
			System.out.println("Time to add");
			BookUser bookUser = new BookUser();
			if(book.getQuantity() > 0)
				book.setQuantity(book.getQuantity() - 1);
			if(book.getQuantity() <= 0) {
				book.setStatus("Not Available");
				bookRepo.save(book);
				return;
			}
			bookUser.setBook(book);
			bookUser.setUser(user);
			bookUser.setBooksBought(bookUser.getBooksBought() + 1);
			bookUser.setUserName(user.getUserName());
			bookUser.setBookTitle(book.getTitle());
			book.addBookUser(bookUser);
			//user.addBookUser(bookUser);
			//bookRepo.save(book);
			bookUserRepo.save(bookUser);
		}
		else{
			BookUser b = bookUserRepo.findById(x).get();
			System.out.println("Time to update");
			if(book.getQuantity() > 0)
				book.setQuantity(book.getQuantity() - 1);
			if(book.getQuantity() <= 0) {
				book.setStatus("Not Available");
				bookRepo.save(book);
				return;
			}
			
			b.setBook(book);
			b.setUser(user);
			b.setBooksBought(b.getBooksBought() + 1);
			b.setUserName(user.getUserName());
			b.setBookTitle(book.getTitle());
			book.addBookUser(b);
			//user.addBookUser(b);
			//bookRepo.save(book);
			bookUserRepo.save(b);
		}
	}
	
	public List<BookUser> findAllBookUser(){
		return bookUserRepo.findAll();
	}

	@Override
	public void deleteMyBook(String id) {
		bookRepo.deleteById(id);
		
	}

	@Override
	public void saveMyBook(Book book) {
		// TODO Auto-generated method stub
		bookRepo.save(book);
	}

	@Override
	public Book editBook(String id) {
		return bookRepo.findById(id).get();
	}

}
