package com.assignment.college.config;

import com.assignment.college.entity.Author;
import com.assignment.college.entity.Book;
import com.assignment.college.repository.AuthorRepository;
import com.assignment.college.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            // Check if database is already populated
            if (authorRepository.count() > 0) {
                return; // Data already exists, skip initialization
            }

            // Create 10 authors
            Author author1 = new Author("J.K. Rowling", "jk.rowling@example.com");
            Author author2 = new Author("George Orwell", "george.orwell@example.com");
            Author author3 = new Author("Jane Austen", "jane.austen@example.com");
            Author author4 = new Author("Stephen King", "stephen.king@example.com");
            Author author5 = new Author("Agatha Christie", "agatha.christie@example.com");
            Author author6 = new Author("Mark Twain", "mark.twain@example.com");
            Author author7 = new Author("Leo Tolstoy", "leo.tolstoy@example.com");
            Author author8 = new Author("Virginia Woolf", "virginia.woolf@example.com");
            Author author9 = new Author("Franz Kafka", "franz.kafka@example.com");
            Author author10 = new Author("Gabriel García Márquez", "gabriel.marquez@example.com");

            // Save authors to get IDs assigned
            authorRepository.save(author1);
            authorRepository.save(author2);
            authorRepository.save(author3);
            authorRepository.save(author4);
            authorRepository.save(author5);
            authorRepository.save(author6);
            authorRepository.save(author7);
            authorRepository.save(author8);
            authorRepository.save(author9);
            authorRepository.save(author10);

            // Create and add 10 books with authors
            Book book1 = new Book("Harry Potter and the Philosopher's Stone", "Fantasy");
            book1.setAuthor(author1);
            bookRepository.save(book1);

            Book book2 = new Book("1984", "Dystopian");
            book2.setAuthor(author2);
            bookRepository.save(book2);

            Book book3 = new Book("Pride and Prejudice", "Romance");
            book3.setAuthor(author3);
            bookRepository.save(book3);

            Book book4 = new Book("The Shining", "Horror");
            book4.setAuthor(author4);
            bookRepository.save(book4);

            Book book5 = new Book("Murder on the Orient Express", "Mystery");
            book5.setAuthor(author5);
            bookRepository.save(book5);

            Book book6 = new Book("The Adventures of Tom Sawyer", "Adventure");
            book6.setAuthor(author6);
            bookRepository.save(book6);

            Book book7 = new Book("War and Peace", "Historical Fiction");
            book7.setAuthor(author7);
            bookRepository.save(book7);

            Book book8 = new Book("To the Lighthouse", "Modernist");
            book8.setAuthor(author8);
            bookRepository.save(book8);

            Book book9 = new Book("The Metamorphosis", "Absurdist Fiction");
            book9.setAuthor(author9);
            bookRepository.save(book9);

            Book book10 = new Book("One Hundred Years of Solitude", "Magical Realism");
            book10.setAuthor(author10);
            bookRepository.save(book10);
        };
    }
}