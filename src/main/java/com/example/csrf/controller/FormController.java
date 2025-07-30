package com.example.csrf.controller;

import com.example.csrf.model.FormInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("formInput", new FormInput());
        return "form";
    }

    @PostMapping("/submit")
    public String handleSubmit(@ModelAttribute FormInput input, Model model) {
        model.addAttribute("message", "Received: " + input.getData());
        return "form";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}