/**
 * Created by AEr on 11.02.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.bootstrap;

import com.wildcodeschool.serialseries.thymeleaf.entity.User;
import com.wildcodeschool.serialseries.thymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
public class BootstrapAdminUser implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BootstrapAdminUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<User> optionalAdmin = userRepository.findByName("admin");
        if (optionalAdmin.isEmpty()) {
            System.out.println("*** No admin user, creating admin/admin");
            User admin = new User();
            admin.setName("admin");
            admin.setRole("ADMIN");
            admin.setPassword(passwordEncoder.encode("admin"));
            userRepository.save(admin);
        }
    }


}
