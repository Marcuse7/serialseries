package com.wildcodeschool.serialseries.thymeleaf.entity.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
public class User implements UserDetails {

    private static final long serialVersionUID = 5859759120668175499L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;
	private String role;
	private String password;

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

	/*	private String nickName;
	private String eMail;
	private ArrayList<String> Watchlist;      // Preferred stations
	private ArrayList<String> Wantedlist;    // Missing Episodes
	private ArrayList<Integer> StationsPositive;	  // Preferred Stations
	private ArrayList<Integer> StationsNegative;	  // Stations not available

	public ArrayList<String> getWatchlist() {
		return Watchlist;
	}

	public void setWatchlist(ArrayList<String> watchlist) {
		Watchlist = watchlist;
	}

	public ArrayList<String> getWantedlist() {
		return Wantedlist;
	}

	public void setWantedlist(ArrayList<String> wantedlist) {
		Wantedlist = wantedlist;
	}

	public ArrayList<Integer> getStationsPositive() {
		return StationsPositive;
	}

	public void setStationsPositive(ArrayList<Integer> stationsPositive) {
		StationsPositive = stationsPositive;
	}

	public ArrayList<Integer> getStationsNegative() {
		return StationsNegative;
	}

	public void setStationsNegative(ArrayList<Integer> stationsNegative) {
		StationsNegative = stationsNegative;
	}

	public User(int id, String name, String nickName, String eMail, String password) {
		super();
		this.id = id;
		this.name = name;
		this.nickName = nickName;
		this.eMail = eMail;
		this.password = password;
	}

	public User () {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/
	


}
