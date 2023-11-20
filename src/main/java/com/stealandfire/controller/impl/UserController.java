package com.stealandfire.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public String printHello() {
        System.out.println("hello world!");
        return "hello world";
    }
}
