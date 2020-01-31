package com.wildcodeschool.serialseries.thymeleaf.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Series {
	@Id
    private String id;
	private String name;
	private String description;
	private String picture;
	private Float rating;
	private String language;
	private Boolean watched;


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


}
