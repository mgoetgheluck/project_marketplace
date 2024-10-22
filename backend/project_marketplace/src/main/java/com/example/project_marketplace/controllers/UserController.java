package com.example.project_marketplace.controllers;

import com.example.project_marketplace.dto.LoginDto;
import com.example.project_marketplace.dto.UserDto;
import com.example.project_marketplace.response.LoginMessage;
import com.example.project_marketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public String saveUser(@RequestBody UserDto userDto){
        String id = userService.addUser(userDto);
        return id;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){
        LoginMessage loginMessage = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginMessage);
    }

    @GetMapping
    public String hello(){
        return "Hello world";
    }
}
