/**
 * Created by AEr on 07.02.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.service;

import com.wildcodeschool.serialseries.thymeleaf.entity.AdminUserDetails;
import com.wildcodeschool.serialseries.thymeleaf.entity.User;
import com.wildcodeschool.serialseries.thymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final String adminPassword;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, @Value("${admin.password}") String adminPassword) {

        this.userRepository = userRepository;
        this.adminPassword = adminPassword;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if ("admin".equals(username)) {
            return new AdminUserDetails("admin", adminPassword);
        }

        Optional<User> optionalUser = userRepository.findByName(username);

        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return optionalUser.get();

    }
}
