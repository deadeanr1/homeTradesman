package org.andrianb.suntehnic.controller;

import org.andrianb.suntehnic.domain.User;
import org.andrianb.suntehnic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by User on 4/5/2017.
 */

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value="register", method= RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user){
        if (userRepository.findOneByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exist");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }

    @RequestMapping(value = "login/**")//todo change to put request
    public Principal user(Principal principal) {
        return principal;
    }

}
