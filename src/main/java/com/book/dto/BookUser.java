package com.book.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookUser {
	
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "book_id")
	private Book book;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;
	
	private String bookTitle;
	private int booksBought;
	private String userName;
	
	public BookUser(){
		
	}
	
	public BookUser(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getBooksBought() {
		return booksBought;
	}
	public void setBooksBought(int booksBought) {
		this.booksBought = booksBought;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "BookUser [id=" + id + ", book=" + book + ", user=" + user + ", bookTitle=" + bookTitle
				+ ", booksBought=" + booksBought + ", userName=" + userName + "]";
	}
	

}
