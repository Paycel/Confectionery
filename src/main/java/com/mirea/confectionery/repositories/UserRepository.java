package com.mirea.confectionery.repositories;

import com.mirea.confectionery.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
