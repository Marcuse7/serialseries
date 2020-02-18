package com.wildcodeschool.serialseries.thymeleaf.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Series {
	
	@Id
	@Column(columnDefinition="VARCHAR(14)")
    private String id;
	
	@Column(columnDefinition="VARCHAR(120)", nullable=false)
	private String name;
	
	@Column(columnDefinition="VARCHAR(1000)")
	private String description;
	
	@Column(columnDefinition="VARCHAR(200)")
	private String picture;
	
	private Float rating;
	
	@Column(columnDefinition="VARCHAR(3)", nullable=false)
	private String language;
	
	private Boolean watched;
	
	private Boolean is_series;
	
	@OneToMany(mappedBy="series")
	private List<Episode> episodes;

	// this class is "owner" of many-to-many relation, class User is slave and has mappedBy parameter
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="Subscriptions")
	private Set<User> subscribers = new HashSet<>();

	public Series () {

	}

	public Series(String id, String name, String description, String picture, Float rating, String language,
			Boolean watched) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.rating = rating;
		this.language = language;
		this.watched = watched;
	}




	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public Float getRating() {
		return rating;
	}


	public void setRating(Float rating) {
		this.rating = rating;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public Boolean getWatched() {
		return watched;
	}


	public void setWatched(Boolean watched) {
		this.watched = watched;
	}

	public Boolean getIs_series() {
		return is_series;
	}

	public void setIs_series(Boolean is_series) {
		this.is_series = is_series;
	}

	public Set<User> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Set<User> subscribers) {
		this.subscribers = subscribers;
	}

	public void subscribe(User user) {
		if (subscribers == null) {
			subscribers = new HashSet<User>();
			System.out.print("Series.subscribers was null");
		}
		subscribers.add(user);
		System.out.println("User " + user.getName() + " subscribed to series " + this.name);
	}
	
	public void unSubscribe(User user) {
		subscribers.remove(user);
		System.out.println("User " + user.getName() + " unsubscribed from series " + this.name);
	}
	
	public boolean isSubscribedBy(User user) {
		if (subscribers == null) {
			return false;
		}
		return subscribers.contains(user);
	}
}
