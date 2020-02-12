package com.wildcodeschool.serialseries.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wildcodeschool.serialseries.thymeleaf.entity.Episode;


public interface EpisodeRepository extends JpaRepository<Episode, String> {

}
