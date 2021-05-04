package com.mirea.confectionery;

import com.mirea.confectionery.models.Category;
import com.mirea.confectionery.models.Product;
import com.mirea.confectionery.models.User;
import com.mirea.confectionery.repositories.UserRepository;
import com.mirea.confectionery.services.CategoryService;
import com.mirea.confectionery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class ConfectioneryApplication implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(ConfectioneryApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<Category> categories = Arrays.asList(
                new Category("food ingredients"),
                new Category("chocolate, icing, cocoa"),
                new Category("food stamp")
        );
        List<Product> products = Arrays.asList(
                new Product("IL-mix light dry confectionery mix 0.2kg", "mixture", "IL", 6.5f, 150),
                new Product("IL-powdered sugar ultrafine 1kg", "sugar", "IL", 1.6f, 40),

                new Product("CACAO BARRY ALUNGA 41% milk chocolate 1kg", "chocolate", "CACAO BARRY ALUNGA", 18.96f, 30),
                new Product("Callebaut Mona Lisa White Chocolate Pencils 900g", "chocolate", "Callebaut Mona Lisa", 30.11f, 9),

                new Product("Transfer paper for meringue KopyForm A4 25 sheets", "paper", "KopyForm", 30.58f, 2),
                new Product("Wafer paper KopyForm thin A4 1 sheet", "paper", "KopyForm", 0.33f, 50)
        );
        products.get(0).setCategory(categories.get(0));
        products.get(1).setCategory(categories.get(0));

        products.get(2).setCategory(categories.get(1));
        products.get(3).setCategory(categories.get(1));

        products.get(4).setCategory(categories.get(2));
        products.get(5).setCategory(categories.get(2));

        categories.forEach(category -> categoryService.addCategory(category));
        products.forEach(product -> productService.addProduct(product));
    }
}
