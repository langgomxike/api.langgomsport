package com.example.api_langgomsport.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users")
    public String postMethodName(@RequestBody String entity) {
        // TODO: process POST request

        return entity + "Hello";
    }
}