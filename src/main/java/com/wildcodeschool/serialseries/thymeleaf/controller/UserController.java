/**
 * Created by AEr on 24.01.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.controller;

import com.wildcodeschool.serialseries.thymeleaf.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private static final List<UserRepository> users = Arrays.asList(
            new UserRepository(1, "Markus Heinrichs"),
            new UserRepository(2, "monika Messerer"),
            new UserRepository(3, "Robert Duschek"),
            new UserRepository(4, "Kadir Erucu")
    );

    @GetMapping(path = "{userId}")
    public UserRepository getUser(@PathVariable("userId") Integer userId) {
        return users.stream()
                .filter(user -> userId.equals(user.getUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Benutzer " + userId + " existiert nicht"));

    }


}
