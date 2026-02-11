package com.practice.demo.service;

import com.practice.demo.DTO.UserRequestDTO;
import com.practice.demo.DTO.UserResponseDTO;
import com.practice.demo.configuration.UserMapper;
import com.practice.demo.entity.Users;
import com.practice.demo.repository.UserRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class userService {

    private final UserRepo userRepo;

    public userService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserResponseDTO registerUser(UserRequestDTO requestDTO){
        Users user= UserMapper.toEntity(requestDTO);
        userRepo.save(user);
        return UserMapper.toUserDTO(user);
    }

    public List<UserResponseDTO> allUsers(){
        List<Users> users=userRepo.findAll();
        List<UserResponseDTO> allUsers=users.stream().map(UserMapper::toUserDTO).toList();
        return allUsers;
    }

    public Optional<UserResponseDTO> userById(Long id){
        Optional<UserResponseDTO> users=userRepo.findById(id).map(UserMapper::toUserDTO);
        return users;

    }
}
