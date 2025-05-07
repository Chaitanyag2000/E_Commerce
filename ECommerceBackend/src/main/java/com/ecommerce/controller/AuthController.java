package com.ecommerce.controller;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserRepository userRepository;

    public AuthController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseEntity<AuthResponse>createUserHandler(@RequestBody User user) throws UserException{
        String emailId = user.getEmailId();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        User isEmailExit = userRepository.findByEmailId(emailId);

        if(isEmailExit != null){
            throw new UserException("EmailId Is Already Used With Another Account...!");
        }
    }
}
