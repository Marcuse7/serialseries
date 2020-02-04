package com.wildcodeschool.serialseries.thymeleaf.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station {
	@Id
	private int id;
	private String name;
	private String country;
	//private Boolean available;


	public Station(int id, String name, String country, Boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
//		this.available = available;
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

//	public Boolean getAvailable() {
//		return available;
//	}

//	public void setAvailable(Boolean available) {
//		this.available = available;
//	}

}
