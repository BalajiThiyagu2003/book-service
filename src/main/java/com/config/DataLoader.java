package com.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.entity.Book;
import com.repository.BookRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
            Book b1 = new Book();
            b1.setTitle("The Alchemist");
            b1.setAuthor("Paulo Coelho");
            b1.setDescription("A philosophical story about a shepherd's journey to discover his personal legend.");
            b1.setPrice(299.00);
            b1.setIsFeatured(true);
            b1.setIsAvailable(true);
            b1.setImageUrl("https://kitabwalah.com/wp-content/uploads/2024/03/the-alchemist.jpg");

            Book b2 = new Book();
            b2.setTitle("Atomic Habits");
            b2.setAuthor("James Clear");
            b2.setDescription("An easy & proven way to build good habits and break bad ones.");
            b2.setPrice(450.00);
            b2.setIsFeatured(true);
            b2.setIsAvailable(true);
            b2.setImageUrl("https://books.google.co.in/books/publisher/content?id=fo5REQAAQBAJ&pg=PA1&img=1&zoom=3&hl=en&bul=1&sig=ACfU3U1JPo9J8o2UqMIQ1Se8bfLWB2EPZA&w=1280");

            Book b3 = new Book();
            b3.setTitle("Sapiens");
            b3.setAuthor("Yuval Noah Harari");
            b3.setDescription("A brief history of humankind.");
            b3.setPrice(499.00);
            b3.setIsFeatured(true);
            b3.setIsAvailable(true);
            b3.setImageUrl("https://books.google.co.in/books/publisher/content?id=1EiJAwAAQBAJ&pg=PP1&img=1&zoom=3&hl=en&bul=1&sig=ACfU3U2nf4ZzBE_NFma6-FTPoPwEmL0_oA&w=1280");

            Book b4 = new Book();
            b4.setTitle("Clean Code");
            b4.setAuthor("Robert C. Martin");
            b4.setDescription("A handbook of agile software craftsmanship.");
            b4.setPrice(650.00);
            b4.setIsFeatured(true);
            b4.setIsAvailable(true);
            b4.setImageUrl("https://books.google.co.in/books/content?id=_i6bDeoCQzsC&pg=PP1&img=1&zoom=3&hl=en&bul=1&sig=ACfU3U1bApbrEDnCLPcGXJCucXJHOqAmAQ&w=1280");

            bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4));
    }
}