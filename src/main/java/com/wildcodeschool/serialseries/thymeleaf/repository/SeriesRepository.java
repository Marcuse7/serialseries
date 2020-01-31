package com.wildcodeschool.serialseries.thymeleaf.repository;

import com.wildcodeschool.serialseries.thymeleaf.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository <Series, String> {
	
}

