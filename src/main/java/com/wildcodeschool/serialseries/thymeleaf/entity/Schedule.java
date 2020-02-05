package com.wildcodeschool.serialseries.thymeleaf.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Schedule {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private LocalDateTime airDateTime;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="station_id")
	private Station station;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="episode_id")
	private Episode episode;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getAirDateTime() {
		return airDateTime;
	}
	public void setAirDateTime(LocalDateTime airDateTime) {
		this.airDateTime = airDateTime;
	}
	
}
