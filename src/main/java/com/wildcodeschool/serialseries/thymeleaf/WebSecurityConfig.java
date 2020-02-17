/**
 * Created by AEr on 06.02.20.
 */


package com.wildcodeschool.serialseries.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {

        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/images/**", "/styles.css", "/webjars/**").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/confirm").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/", true)
                .and()
                .rememberMe() // defaults to 2 weeks
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    
    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers(
            "https://json.schedulesdirect.org/20141201/image/assets/**"
        );
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }
}
