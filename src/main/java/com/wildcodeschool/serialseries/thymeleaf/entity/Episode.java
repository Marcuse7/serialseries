package com.wildcodeschool.serialseries.thymeleaf.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Episode {
	@Id
	private int id;
	private int number;
	private int season;
	private String description;
	private String picture;
	private float rating;
	private boolean wanted;

	public Episode(int id, int number, int season, String description, String picture, float rating) {
		super();
		this.id = id;
		this.number = number;
		this.season = season;
		this.description = description;
		this.picture = picture;
		this.rating = rating;
	}

	public Episode () {

	}


	public Episode(int id, int number, int season, String description, String picture, float rating, boolean wanted) {
		super();
		this.id = id;
		this.number = number;
		this.season = season;
		this.description = description;
		this.picture = picture;
		this.rating = rating;
		this.wanted = wanted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public boolean isWanted() {
		return wanted;
	}

	public void setWanted(boolean wanted) {
		this.wanted = wanted;
	}



}
