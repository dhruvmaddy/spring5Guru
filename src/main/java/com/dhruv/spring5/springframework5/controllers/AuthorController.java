package com.dhruv.spring5.springframework5.controllers;

import com.dhruv.spring5.springframework5.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthor(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        return "authors";
    }
}
