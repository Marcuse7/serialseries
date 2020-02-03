/**
 * Created by AEr on 29.01.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.wildcodeschool.serialseries.thymeleaf.config.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()// TODO
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(USER.name())
//                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(ApplicationUserPermission.USER_WRITE.getPermission())
//                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(ApplicationUserPermission.USER_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(ApplicationUserPermission.USER_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails markusUser = User.builder()
                .username("markus")
                .password(passwordEncoder.encode("heinrichs"))
//                .roles(USER.name()) // ROLE_USER
                .authorities(USER.getGrantedAuthorities())
                .build();

        UserDetails moniUser = User.builder()
                .username("moni")
                .password(passwordEncoder.encode("messerer"))
//                .roles(USER.name()) // ROLE_USER
                .authorities(USER.getGrantedAuthorities())
                .build();

        UserDetails robertUser = User.builder()
                .username("robert")
                .password(passwordEncoder.encode("duschek"))
//                .roles(USER.name()) // ROLE_USER
                .authorities(USER.getGrantedAuthorities())
                .build();

        UserDetails kadirUser = User.builder()
                .username("kadir")
                .password(passwordEncoder.encode("erucu"))
//                .roles(USER.name()) // ROLE_USER
                .authorities(USER.getGrantedAuthorities())
                .build();

        UserDetails adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password123"))
//                .roles(ADMIN.name()) // ROLE_ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails adminTraineeUser = User.builder()
                .username("trainee")
                .password(passwordEncoder.encode("password123"))
//                .roles(ADMINTRAINEE.name()) // ROLE_ADMINTRAINEE
                .authorities(ADMINTRAINEE.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                markusUser,
                moniUser,
                robertUser,
                kadirUser,
                adminUser,
                adminTraineeUser

        );
    }


}
