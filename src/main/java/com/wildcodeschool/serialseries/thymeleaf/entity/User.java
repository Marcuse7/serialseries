package com.wildcodeschool.serialseries.thymeleaf.entity;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User implements UserDetails {

    private static final long serialVersionUID = 5859759120668175499L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="VARCHAR(50)", unique=true)
	private String name;
	
	@Column(columnDefinition="VARCHAR(14)")
	private String role;
	
	@Column(columnDefinition="VARCHAR(100)")
	private String password;
	
	
	
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="subscribers", cascade = CascadeType.ALL)
	private Set<Series> subscriptions = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
        return Collections.singletonList(authority);
    }

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
