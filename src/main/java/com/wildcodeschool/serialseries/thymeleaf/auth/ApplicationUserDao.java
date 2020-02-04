/**
 * Created by AEr on 04.02.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.auth;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
