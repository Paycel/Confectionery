package com.mirea.confectionery.services;

import com.mirea.confectionery.models.User;
import com.mirea.confectionery.repositories.ProductRepository;
import com.mirea.confectionery.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void addUser() {
        User user = new User("name", "password", "email");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Assertions.assertTrue(bCryptPasswordEncoder.matches("password", user.getPassword()));
        userService.addUser(user);
        Mockito.when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
    }

    @Test
    void login() {
        User user = new User("name", "password", "email");
        userService.addUser(user);

        Mockito.when(userRepository.findByUsernameOrEmail("name", "email")).thenReturn(user);

        User result1 = userService.login("name", "email", "password");
        Assertions.assertNotNull(result1);

        User result2 = userService.login("name1", "email", "password");
        Assertions.assertNull(result2);
    }
}
