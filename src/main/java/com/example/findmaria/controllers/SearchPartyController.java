package com.example.findmaria.controllers;

import com.example.findmaria.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@Validated
public class SearchPartyController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit-search-party")
    public String submitSearchParty(@Valid @RequestParam(required = false) String name,
                                    @Valid @RequestParam(required = false) String email,
                                    @Valid @RequestParam(required = false, defaultValue = "false") boolean anonymous) {
        emailService.sendEmail(name, email);
        return "redirect:/search-party-signup?success=true";
    }
}
