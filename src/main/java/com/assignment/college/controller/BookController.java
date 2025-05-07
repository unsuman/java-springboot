package com.assignment.college.controller;

import com.assignment.college.entity.Book;
import com.assignment.college.entity.Author;
import com.assignment.college.service.BookService;
import com.assignment.college.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooksWithAuthors());
        return "books/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "books/add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, @RequestParam Long authorId, RedirectAttributes redirectAttributes) {
        try {
            Optional<Author> authorOpt = authorService.getAuthorById(authorId);
            if (authorOpt.isPresent()) {
                book.setAuthor(authorOpt.get());
                bookService.saveBook(book);
                redirectAttributes.addFlashAttribute("success", "Book added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("error", "Author not found.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error adding book: " + e.getMessage());
        }
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Book> bookOpt = bookService.getBookById(id);
        if (bookOpt.isPresent()) {
            model.addAttribute("book", bookOpt.get());
            model.addAttribute("authors", authorService.getAllAuthors());
            return "books/edit";
        } else {
            redirectAttributes.addFlashAttribute("error", "Book not found.");
            return "redirect:/books";
        }
    }

    @PostMapping("/edit")
    public String updateBook(@ModelAttribute Book book, @RequestParam Long authorId, RedirectAttributes redirectAttributes) {
        try {
            Optional<Author> authorOpt = authorService.getAuthorById(authorId);
            if (authorOpt.isPresent()) {
                book.setAuthor(authorOpt.get());
                bookService.updateBook(book);
                redirectAttributes.addFlashAttribute("success", "Book updated successfully!");
            } else {
                redirectAttributes.addFlashAttribute("error", "Author not found.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating book: " + e.getMessage());
        }
        return "redirect:/books";
    }
}
