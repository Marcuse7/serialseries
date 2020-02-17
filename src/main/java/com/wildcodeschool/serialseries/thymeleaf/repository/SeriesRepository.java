package com.wildcodeschool.serialseries.thymeleaf.repository;

import com.wildcodeschool.serialseries.thymeleaf.entity.Series;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository <Series, String> {

	Object findByNameContaining(String suchbegriff);
	
	List <Object> findByNameOrDescriptionContaining (String name, String description);


	
}

