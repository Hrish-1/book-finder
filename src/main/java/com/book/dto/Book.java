package com.book.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Book {
	@Id
	@Column(name = "book_id",length = 64)
	private String isbn;
	private String title;
	private  String img;
	private  String rating;
	private  String lang;
	private  String author;
	private  int quantity;
	private String status;
	
	@OneToMany(mappedBy = "book")
	Set<BookUser> bookUsers = new HashSet<BookUser>();
	
	public Book() {
		super();
		
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

	public Set<BookUser> getBookUser() {
		return bookUsers;
	}

	public void setBookUser(Set<BookUser> bookUsers) {
		this.bookUsers = bookUsers;
	}
	
	public void addBookUser(BookUser bookUser) {
		this.bookUsers.add(bookUser);
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<BookUser> getBookUsers() {
		return bookUsers;
	}

	public void setBookUsers(Set<BookUser> bookUsers) {
		this.bookUsers = bookUsers;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", img=" + img + ", rating=" + rating + ", lang=" + lang
				+ ", author=" + author + "]";
	}
	
	
}
