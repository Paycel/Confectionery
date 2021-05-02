package com.mirea.confectionery.controllers;

import com.mirea.confectionery.models.User;
import com.mirea.confectionery.repositories.UserRepository;
import com.mirea.confectionery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @CrossOrigin(origins = "http://localhost:4200")
    void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

}
