package com.example.findmaria.controllers;

import com.example.findmaria.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/contact")
    public String showContactForm() {
        return "contact";
    }

    @Value("${EMAIL_USERNAME}")
    private String EMAIL_USERNAME;

    @PostMapping("/contact")
    public String submitContactForm(@Valid @RequestParam("name") String name,
                                    @Valid @RequestParam("email") String email,
                                    @Valid @RequestParam("message") String message) {

        String subject = "Contact Submission From " + name;
        String content = "Name: " + name + "\nEmail: " + email + "\nMessage: " + message;

        emailService.sendEmail(EMAIL_USERNAME, subject, content);

        return "redirect:/contact?success=true";
    }
}
