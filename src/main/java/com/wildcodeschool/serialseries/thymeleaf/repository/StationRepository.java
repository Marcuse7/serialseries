package com.wildcodeschool.serialseries.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.serialseries.thymeleaf.entity.Station;

	
	@Repository
	public interface StationRepository extends JpaRepository<Station, String> {
		}



