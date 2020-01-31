package com.wildcodeschool.serialseries.thymeleaf.controller;


import com.wildcodeschool.serialseries.thymeleaf.entity.Series;
import com.wildcodeschool.serialseries.thymeleaf.repository.SeriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import javax.persistence.Persistence;


@Controller
public class GetAllSeriesController {
	
	@Autowired
    private SeriesRepository seriesRepository;



	@GetMapping("/series/all")
    public String showAllSeries(Model out) {
		out.addAttribute ("series", seriesRepository.findAll());
		

		
		
        return "series_all";
    }
}
