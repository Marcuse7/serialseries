package com.wildcodeschool.serialseries.thymeleaf.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Station {
	@Id
	@Column(columnDefinition="VARCHAR(12)")
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(columnDefinition="VARCHAR(3)", nullable=false)
	private String country;

	private Boolean available;
	
	@Column(columnDefinition="VARCHAR(255)")
	private String picture;
	
	@OneToMany(mappedBy="station")
	private List<Schedule> schedules;


	public Station(int id, String name, String country, Boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.available = available;
	}

	public Station () {

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

	public List<Schedule> getSchedules() {
		return schedules;
	}

}
