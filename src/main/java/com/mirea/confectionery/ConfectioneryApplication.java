package com.mirea.confectionery;

import com.mirea.confectionery.models.User;
import com.mirea.confectionery.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ConfectioneryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfectioneryApplication.class, args);
    }


}
