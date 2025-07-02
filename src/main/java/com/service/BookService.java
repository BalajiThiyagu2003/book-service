package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Book;
import com.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getFeaturedBooks() {
        return bookRepository.findByIsFeaturedTrueAndIsAvailableTrue();
    } 

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void markBooksUnavailable(List<String> titles) {
        List<Book> books = bookRepository.findAll();
        for (Book b : books) {
            if (titles.contains(b.getTitle())) {
                b.setIsAvailable(false);
            }
        }
        bookRepository.saveAll(books);
    }

	
}
