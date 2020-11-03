package com.book.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.dto.User;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
			
	List<User> findByUserName(String userName);
}
