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

    public boolean addProduct(Product product) {
        if (productRepository.findByFullName(product.getFullName()) == null) {
            productRepository.save(product);
            return true;
        }
        return false;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<String> findDistinctProductNames() {
        return productRepository.findDistinctByProductName().stream()
                .map(Product::getProductName)
                .collect(Collectors.toList());
    }

    public List<String> findDistinctBrandNames() {
        return productRepository.findDistinctByBrandName().stream()
                .map(Product::getBrandName)
                .collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return productRepository.getOne(id);
    }

    public int updateProductAmount(Long id, Long new_amount) {
        return productRepository.updateAmount(id, new_amount);
    }

    public boolean updateAmounts(List<Product> products) {
        List<Product> old_product = findAll();
        products.forEach(product -> updateProductAmount(product.getId(), (long) (old_product.stream()
                .filter(t -> t.getId().equals(product.getId()))
                .findFirst().get()
                .getAmount() - product.getAmount())));
        return true;
    }
}
