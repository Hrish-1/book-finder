package com.book.service;

import java.util.List;

import com.book.dto.User;

public interface UserService {
	
	public void addUser(User user);
	public List<User> findUser(User user);
}
