package com.assignment.college.controller;

import com.assignment.college.entity.Author;
import com.assignment.college.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String listAuthors(Model model) {    
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/add";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author, RedirectAttributes redirectAttributes) {
        try {
            authorService.saveAuthor(author);
            redirectAttributes.addFlashAttribute("success", "Author added successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error adding author: " + e.getMessage());
        }
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Author> authorOpt = authorService.getAuthorById(id);
        if (authorOpt.isPresent()) {
            model.addAttribute("author", authorOpt.get());
            return "authors/edit";
        } else {
            redirectAttributes.addFlashAttribute("error", "Author not found.");
            return "redirect:/authors";
        }
    }

    @PostMapping("/edit")
    public String updateAuthor(@ModelAttribute Author author, RedirectAttributes redirectAttributes) {
        try {
            authorService.updateAuthor(author);
            redirectAttributes.addFlashAttribute("success", "Author updated successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating author: " + e.getMessage());
        }
        return "redirect:/authors";
    }
}
