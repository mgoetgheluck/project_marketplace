package com.example.project_marketplace.services.Impl;

import com.example.project_marketplace.dto.LoginDto;
import com.example.project_marketplace.dto.UserDto;
import com.example.project_marketplace.models.User;
import com.example.project_marketplace.response.LoginMessage;
import com.example.project_marketplace.repository.UserRepository;
import com.example.project_marketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {
        User user = new User(
                userDto.getUserId(),
                userDto.getUserName(),
                userDto.getEmail(),
                this.passwordEncoder.encode(userDto.getPassword())
        );

        userRepository.save(user);


        return user.getUserName();
    }

    @Override
    public LoginMessage loginUser(LoginDto loginDto) {
        String message = "";
        User user1 = userRepository.findByEmail(loginDto.getEmail());
        if(user1 != null){
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);
            if(isPasswordRight){
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if(user.isPresent()){
                    return new LoginMessage("Login success", true);
                }
                else {
                    return new LoginMessage("Login failed", false);
                }
            }
            else {
                return new LoginMessage("Password does not match", false);
            }
        }
        else {
            return new LoginMessage("Email does not exist", false);
        }
    }
}
