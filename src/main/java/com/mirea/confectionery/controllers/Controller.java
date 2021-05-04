package com.mirea.confectionery.controllers;

import com.mirea.confectionery.models.Category;
import com.mirea.confectionery.models.Product;
import com.mirea.confectionery.models.User;
import com.mirea.confectionery.repositories.UserRepository;
import com.mirea.confectionery.services.CategoryService;
import com.mirea.confectionery.services.ProductService;
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
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping("/users")
    User login(String username, String email, String password){
        return userService.login(username, email, password);
    }

    @GetMapping("/products")
    List<Product> findAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/categories")
    List<Category> findAllCategories(){
        return categoryService.findAll();
    }

}
