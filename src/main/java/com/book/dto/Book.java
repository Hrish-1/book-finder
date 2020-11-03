package com.book.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@Column(length = 64)
	String isbn;
	String title;
	String img;
	String rating;
	String lang;
	String author;
	
	public Book() {
		super();
		
	}

	public Book(String isbn, String title, String img, String rating, String lang, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.img = img;
		this.rating = rating;
		this.lang = lang;
		this.author = author;
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

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", img=" + img + ", rating=" + rating + ", lang=" + lang
				+ ", author=" + author + "]";
	}
	
	
}
