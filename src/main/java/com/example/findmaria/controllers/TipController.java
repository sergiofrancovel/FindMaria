package com.example.findmaria.controllers;

import com.example.findmaria.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Validated
@Controller
public class TipController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit-tip")
    public String submitTip(
            @Valid @RequestParam(required = false) @Email String email,
            @Valid @RequestParam(required = false) String name,
            @Valid @RequestParam @NotBlank String tip,
            @Valid @RequestParam(required = false, defaultValue = "false") boolean anonymous) {

        emailService.sendMailTip(name, email, tip, anonymous);
        return "redirect:/submit-tip?success=true";
    }
}
