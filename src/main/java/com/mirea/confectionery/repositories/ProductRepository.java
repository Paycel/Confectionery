package com.mirea.confectionery.repositories;

import com.mirea.confectionery.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByFullName(String fullName);
}
