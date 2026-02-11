package com.practice.demo.controller;

//import com.practice.demo.entity.Users;
import com.practice.demo.DTO.UserRequestDTO;
import com.practice.demo.DTO.UserResponseDTO;
import com.practice.demo.configuration.UserMapper;
import com.practice.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/demo")
public class Controller {

    @Autowired
    private userService service;

    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO requestDTO){
        UserResponseDTO savedUser=service.registerUser(requestDTO);
        URI location=URI.create("/demo/"+savedUser.getId());
        return ResponseEntity.created(location).body(savedUser);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserResponseDTO>> allUsers(){
        return ResponseEntity.ok(service.allUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> userById(@PathVariable Long id){
        return service.userById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
