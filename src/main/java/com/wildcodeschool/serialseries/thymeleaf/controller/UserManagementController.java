/**
 * Created by AEr on 30.01.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.controller;

import com.wildcodeschool.serialseries.thymeleaf.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/users")
public class UserManagementController {

    private static final List<User> USERS = Arrays.asList(
            new User(1, "Markus Heinrichs"),
            new User(2, "Monika Messerer"),
            new User(3, "Robert Duschek"),
            new User(4, "Kadir Erucu")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<User> getAllUsers() {
        System.out.println("getAllUsers");
        return USERS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public void registerNewUser(@RequestBody User user) {
        System.out.println("registerNewUser");
        System.out.println(user);
    }

    @DeleteMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println("deleteUser");
        System.out.println(userId);

    }

    @PutMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
        System.out.println("updateUser");
        System.out.println(String.format("%s %s", userId, user));
    }
}
