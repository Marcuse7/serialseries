package com.wildcodeschool.serialseries.thymeleaf.repository;

import com.wildcodeschool.serialseries.thymeleaf.entity.Series;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository <Series, String> {

	Series findByNameContaining(String suchbegriff);
	
	Optional<Series> findById(String seriesId);
	
	List <Series> findByNameOrDescriptionContaining (String name, String description);

	
	List <Series> findFirst30ByNameOrDescriptionContaining (String name, String description);



	
}

