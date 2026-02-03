package com.practice.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo")
public class Controller {
    @PostMapping
    public void registerUser(){
        System.out.println("this is s test");

    }
}
