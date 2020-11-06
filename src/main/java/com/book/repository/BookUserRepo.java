package com.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.dto.BookUser;

@Repository
public interface BookUserRepo extends JpaRepository<BookUser,Integer> {

	
	@Query(value = "select id from BookUser where book_id = ?1 and user_id = ?2")
	Integer getId(String book_id,int user_id);
	
	
}
