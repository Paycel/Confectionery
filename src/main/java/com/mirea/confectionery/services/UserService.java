package com.mirea.confectionery.services;

import com.mirea.confectionery.models.Role;
import com.mirea.confectionery.models.User;
import com.mirea.confectionery.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean addUser(User user) {
        User userDB = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
        if (userDB != null)
            return false;
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (!user.getUsername().equals("admin"))
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        else
            user.setRoles(Collections.singleton(new Role(2L, "ROLE_ADMIN")));
        userRepository.save(user);
        return true;
    }

    public User login(String username, String email, String password){
        User user = userRepository.findByUsernameOrEmail(username, email);
        if (user == null)
            return null;
        if (bCryptPasswordEncoder.matches(password, user.getPassword()))
            return user;
        else return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}