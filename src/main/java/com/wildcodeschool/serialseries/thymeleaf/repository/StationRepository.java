package com.wildcodeschool.serialseries.thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.serialseries.thymeleaf.entity.Station;

	
	@Repository
	public interface StationRepository extends JpaRepository<Station, Integer> {

	    List<Station> findByNameContaining(String name);
		}



