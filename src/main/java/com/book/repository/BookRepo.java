package com.book.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.dto.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,String>{
	
	@Query(value = "from Book where title = ?1")
	List<Book> findAllByTitle(String title);

}
