package com.wildcodeschool.serialseries.thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wildcodeschool.serialseries.thymeleaf.entity.Episode;
import com.wildcodeschool.serialseries.thymeleaf.entity.Series;


public interface EpisodeRepository extends JpaRepository<Episode, String> {
	
	List<Episode> findBySeriesIs(Series series);

}
