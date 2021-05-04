package com.mirea.confectionery.services;

import com.mirea.confectionery.models.Product;
import com.mirea.confectionery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public boolean addProduct(Product product){
        if (productRepository.findByProductName(product.getProductName()) == null){
            productRepository.save(product);
            return true;
        }
        return false;
    }

}
