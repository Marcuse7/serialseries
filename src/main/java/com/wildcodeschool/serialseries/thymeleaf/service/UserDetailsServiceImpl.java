/**
 * Created by AEr on 07.02.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.service;

import com.wildcodeschool.serialseries.thymeleaf.entity.user.User;
import com.wildcodeschool.serialseries.thymeleaf.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByName(username);
        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return optionalUser.get();
    }
}
