package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * GREETING_TEXT → zmienna środowiskowa
     * :Hello from default → fallback, jeśli ENV nie istnieje
     * brak application.properties → cloud-style
     * */
    @Value("${GREETING_TEXT:Hello from default}")
    private String greeting;

    @Value("${spring.profiles.active:default}")
    private String profile;

    @GetMapping("/hello")
    public String hello() {
        return greeting;
    }

    @GetMapping("/profile")
    public String profile() {
        return profile;
    }

    @GetMapping("/boom")
    public String boom() {
        throw new IllegalArgumentException("Error occurred during request - booom");
    }

    @GetMapping("/storm")
    public String storm() {
        return greeting + " " + profile + " " + "storm";
    }
}
