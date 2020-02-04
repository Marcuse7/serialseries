package com.wildcodeschool.serialseries.thymeleaf.repository;


//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.serialseries.thymeleaf.entity.Station;

	
	@Repository
	public interface StationRepository extends JpaRepository<Station, Long> {
	
//		List<Station> findbyNameContaining(String name);
//		List <Station> findAll();
	}


