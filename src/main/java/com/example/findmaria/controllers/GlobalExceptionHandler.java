package com.example.findmaria.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationExceptions(MethodArgumentNotValidException ex, Model model) {
        model.addAttribute("errorMessage", "Invalid input provided. Please correct the errors and try again.");
        return "error";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleExceptions(Exception ex, Model model) {
        model.addAttribute("errorMessage", "An error occurred. We're looking into " +
                "this and will get it fixed as soon as possible.");
        return "error";
    }
}
