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
    @Value("${greeting_text:Hello from default}")
    private String greeting;

    @Value("${greeting_text_v2:Hello from default V2}")
    private String greetingV2;

    @Value("${spring.profiles.active:default}")
    private String profile;

    @GetMapping("/hello")
    public String hello() {
        return greeting;
    }

    @GetMapping("/hello/v2")
    public String helloV2() {
        return greetingV2;
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

    @GetMapping("/ghost")
    public String ghost() {
        return greeting + " " + profile + " " + "ghost";
    }
}
