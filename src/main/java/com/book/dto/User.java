package com.book.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;
	private String name;
	@Column(unique = true,length = 64)
	private String userName;
	private  String password;
	private  String mail;
	
	@OneToMany(mappedBy = "user")
	Set<BookUser> bookUsers = new HashSet<BookUser>();
	
	public User() {
		super();
	}
	
	public Set<BookUser> getBookUsers() {
		return bookUsers;
	}

	public void setBookUsers(Set<BookUser> bookUsers) {
		this.bookUsers = bookUsers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	public void addBookUser(BookUser bookUser) {
		this.bookUsers.add(bookUser);
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + ", mail="
				+ mail + "]";
	}
	
}
