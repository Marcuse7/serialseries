/**
 * Created by AEr on 30.01.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.controller;

import com.wildcodeschool.serialseries.thymeleaf.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/users")
public class UserManagementController {

    private static final List<UserRepository> USERS = Arrays.asList(
            new UserRepository(1, "Markus Heinrichs"),
            new UserRepository(2, "Monika Messerer"),
            new UserRepository(3, "Robert Duschek"),
            new UserRepository(4, "Kadir Erucu")
    );

    @GetMapping
    public List<UserRepository> getAllUsers() {
        System.out.println("getAllUsers");
        return USERS;
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user) {
        System.out.println("registerNewUser");
        System.out.println(user);
    }

    @DeleteMapping(path = "{userId")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println("deleteUser");
        System.out.println(userId);

    }

    @PutMapping(path = "{userId")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
        System.out.println("updateUser");
        System.out.println(String.format("%s %s", userId, user));
    }
}
