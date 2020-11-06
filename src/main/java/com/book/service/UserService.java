package com.book.service;

import java.util.List;

import com.book.dto.User;

public interface UserService {
	
	public void addUser(User user);
	public List<User> findUser(User user);
	public List<User> showAllUsers();
	public void deleteMyUser(int id);
	public User editUser(int id);
	void saveMyUser(User user);
	//public Object findByUsernameAndPassword(String userName, String password);
}
