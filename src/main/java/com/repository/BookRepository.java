package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByIsFeaturedTrueAndIsAvailableTrue();

}
