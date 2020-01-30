/**
 * Created by AEr on 24.01.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.repository;

public class UserRepository {

    private final Integer userId;
    private final String userName;

    public UserRepository(Integer userId,
                          String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
