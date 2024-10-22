package com.example.project_marketplace.services;

import com.example.project_marketplace.dto.LoginDto;
import com.example.project_marketplace.dto.UserDto;
import com.example.project_marketplace.response.LoginMessage;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String addUser(UserDto userDto);

    LoginMessage loginUser(LoginDto loginDto);
}
