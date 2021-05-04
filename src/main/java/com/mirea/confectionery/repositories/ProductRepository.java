package com.mirea.confectionery.repositories;

import com.mirea.confectionery.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByFullName(String fullName);
    @Query(value = "SELECT DISTINCT on (p.product_name) p.* FROM products p", nativeQuery = true)
    List<Product> findDistinctByProductName();
    @Query(value = "SELECT DISTINCT on (p.brand_name) p.* FROM products p", nativeQuery = true)
    List<Product> findDistinctByBrandName();
}
