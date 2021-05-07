package com.mirea.confectionery.repositories;

import com.mirea.confectionery.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByFullName(String fullName);
    @Query(value = "SELECT DISTINCT on (p.product_name) p.* FROM products p", nativeQuery = true)
    List<Product> findDistinctByProductName();
    @Query(value = "SELECT DISTINCT on (p.brand_name) p.* FROM products p", nativeQuery = true)
    List<Product> findDistinctByBrandName();
    @Modifying
    @Query("update Product t set t.amount = :amount where t.id = :id")
    @Transactional
    int updateAmount(@Param("id") Long id, @Param("amount") Long amount);
}
