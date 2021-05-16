package com.mirea.confectionery.services;

import com.mirea.confectionery.models.Product;
import com.mirea.confectionery.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;

    @Test
    void addProduct() {
        Product product = new Product("name", "pname", "bname", 1f, 10);
        productService.addProduct(product);

        Mockito.when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
    }

    @Test
    void findAll() {
        Product product = new Product("name", "pname", "bname", 1f, 10);
        productService.addProduct(product);

        Mockito.when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
    }

    @Test
    void findById() {
        Product product = new Product("name", "pname", "bname", 1f, 10);
        productService.addProduct(product);

        Mockito.when(productRepository.getOne(product.getId())).thenReturn(product);
    }
}
