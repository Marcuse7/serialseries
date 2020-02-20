package com.wildcodeschool.serialseries.thymeleaf.entity;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "user")
      @Getter
@Setter
public class User implements UserDetails {

    private static final long serialVersionUID = 5859759120668175499L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	
	@Column(columnDefinition="VARCHAR(50)", unique=true)
	private String name;
	
	@Column(columnDefinition="VARCHAR(14)")
	private String role;

	@ManyToMany(fetch=FetchType.EAGER, mappedBy="subscribers", cascade = CascadeType.ALL)
	private Set<Series> subscriptions = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
        return Collections.singletonList(authority);
    }

    // User-Registrierung
    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    //    @Transient
    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    @NotEmpty(message = "Please provide your first name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Please provide your last name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "confirmation_token")
    private String confirmationToken;

//    public String getConfirmationToken() {
//        return confirmationToken;
//    }
//
//    public void setConfirmationToken(String confirmationToken) {
//        this.confirmationToken = confirmationToken;
//    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public boolean getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean value) {
//        this.enabled = value;
//    }

    // Login Einstellungen
    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public void subscribe(Series series) {
    	if (subscriptions == null) {
    		subscriptions = new HashSet<Series>(10);
    		System.out.println("subscriptions were null");
    	}
    	subscriptions.add(series);
    	
    }
    
    public void unsubscribe(Series series) {
    	subscriptions.remove(series);
    }

}
