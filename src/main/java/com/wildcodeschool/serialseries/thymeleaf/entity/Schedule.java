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
	private Integer id;
	
	@Column(nullable=false)
	private LocalDateTime airDateTime;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="station_id")
	private Station station;
	
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public Episode getEpisode() {
		return episode;
	}
	public void setEpisode(Episode episode) {
		this.episode = episode;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="episode_id")
	private Episode episode;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getAirDateTime() {
		return airDateTime;
	}
	public void setAirDateTime(LocalDateTime airDateTime) {
		this.airDateTime = airDateTime;
	}
	
}
