package com.example.findmaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


@Controller
public class HomeController {
    int counter=1;

    @GetMapping("/")
    public String home(Model model) {
        System.out.println(counter++);
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/email-templates")
    public String emailTemplates(Model model) {
        return "email-templates";
    }

    @GetMapping("/submit-tip")
    public String submitTip(Model model) {
        return "submit-tip";
    }

    @GetMapping("/get-involved")
    public String getInvolved(Model model) {
        return "get-involved";
    }

    @GetMapping("/search-party-signup")
    public String showSearchPartySignup() {
        return "search-party-signup";
    }

    @GetMapping("/news")
    public String news(Model model) {
        return "news";
    }

    @GetMapping("/resources")
    public String resources(Model model) {
        return "resources";
    }

}

