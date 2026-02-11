package com.practice.demo.configuration;

import com.practice.demo.DTO.UserRequestDTO;
import com.practice.demo.DTO.UserResponseDTO;
import com.practice.demo.entity.Users;

public class UserMapper {
    public static Users toEntity(UserRequestDTO requestDTO){
        Users user=new Users();
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());
        return user;
    }

    public static UserResponseDTO toUserDTO(Users user){
        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        return userResponseDTO;
    }
}
