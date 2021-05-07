package com.mirea.confectionery.repositories;

import com.mirea.confectionery.models.Product;
import com.mirea.confectionery.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUsernameOrEmail(String username, String email);
    @Modifying
    @Query("update User t set t.cart = :cart where t.id = :id")
    @Transactional
    int updateCart(@Param("id") Long id, @Param("cart") Set<Product> cart);
}
