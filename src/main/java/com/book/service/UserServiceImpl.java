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
	public List<User> showAllUsers(){
		return (List<User>) userRepo.findAll();
	}

	@Override
	public void deleteMyUser(int id) {
		userRepo.deleteById(id);
	}

	@Override
	public User editUser(int id) {
		return userRepo.findById(id).get();
		
	}

	@Override
	public void saveMyUser(User user) {
		userRepo.save(user);
	}

//	@Override
//	public Object findByUsernameAndPassword(String userName, String password) {
//		return userRepo.findByUserNameAndPassword(userName, password);
//	}

}
