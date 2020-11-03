package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dto.User;
import com.book.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public void addUser(User user) {
		userRepo.save(user);
	}

	@Override
	public List<User> findUser(User user) {
		return userRepo.findByUserName(user.getUserName());
	}

}
