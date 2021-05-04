package com.mirea.confectionery.services;

import com.mirea.confectionery.models.Product;
import com.mirea.confectionery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public boolean addProduct(Product product){
        if (productRepository.findByFullName(product.getFullName()) == null){
            productRepository.save(product);
            return true;
        }
        return false;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<String> findDistinctProductNames(){
        return productRepository.findDistinctByProductName().stream()
                .map(Product::getProductName)
                .collect(Collectors.toList());
    }

    public List<String> findDistinctBrandNames(){
        return productRepository.findDistinctByBrandName().stream()
                .map(Product::getBrandName)
                .collect(Collectors.toList());
    }


}
