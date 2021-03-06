package com.wildcodeschool.serialseries.thymeleaf.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Station {
	@Id
	@Column(columnDefinition="VARCHAR(12)")
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(columnDefinition="VARCHAR(3)", nullable=false)
	private String country;
	
	private Boolean available;
	
	@Column(columnDefinition="VARCHAR(255)")
	private String picture;
	
	@OneToMany(mappedBy="station", fetch=FetchType.LAZY) 
	private List<Schedule> schedules;


	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Station(Integer id, String name, String country,String picture, Boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.available = available;
		this.picture = picture;
	}

	public Station () {

	}

	public Integer getId() {
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
