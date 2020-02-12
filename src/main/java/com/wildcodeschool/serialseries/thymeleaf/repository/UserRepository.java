/**
 * Created by AEr on 07.02.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.repository;

import com.wildcodeschool.serialseries.thymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

public Optional<User> findByName(String name);

}
