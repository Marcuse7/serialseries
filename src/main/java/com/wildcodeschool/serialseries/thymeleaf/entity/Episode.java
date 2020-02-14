package com.wildcodeschool.serialseries.thymeleaf.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Episode {
	@Id
	@Column(columnDefinition="VARCHAR(14)")
	private String id;
	
	@Column(columnDefinition="VARCHAR(120)", nullable=false)
	private String name;
	
	@Column(columnDefinition="VARCHAR(150)", nullable=false)
	private String episodeTitle;
	
	@Column(nullable=true)
	private Integer number;
	
	@Column(nullable=true)
	private Integer season;
	
	@Column(columnDefinition="VARCHAR(3)", nullable=false)
	private String language;
	
	@Column(columnDefinition="VARCHAR(1000)")
	private String description;
	
	@Column(columnDefinition="VARCHAR(200)")
	private String picture;
	
	private Float rating;
	
	@Column(nullable=true)
	private Boolean is_series;
	
	@Column(nullable=true)
	private Boolean wanted;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="series_id")
	private Series series;
	
	@OneToMany(mappedBy="episode")
	private List<Schedule> schedules;

	public Episode(String id, Integer number, Integer season, String description, String picture, Float rating) {
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


	public Episode(String id, Integer number, Integer season, String description, String picture, Float rating, Boolean wanted) {
		super();
		this.id = id;
		this.number = number;
		this.season = season;
		this.description = description;
		this.picture = picture;
		this.rating = rating;
		this.wanted = wanted;
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getSeason() {
		return season;
	}

	public void setSeason(Integer season) {
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

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Boolean isWanted() {
		return wanted;
	}

	public void setWanted(Boolean wanted) {
		this.wanted = wanted;
	}

	public Boolean isIs_series() {
		return is_series;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

}
