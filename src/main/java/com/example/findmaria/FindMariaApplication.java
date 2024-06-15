package com.example.findmaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class FindMariaApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        System.setProperty("EMAIL_HOST", dotenv.get("EMAIL_HOST"));
        System.setProperty("EMAIL_PORT", dotenv.get("EMAIL_PORT"));
        System.setProperty("EMAIL_USERNAME", dotenv.get("EMAIL_USERNAME"));
        System.setProperty("EMAIL_PASSWORD", dotenv.get("EMAIL_PASSWORD"));
        SpringApplication.run(FindMariaApplication.class, args);
    }
}
