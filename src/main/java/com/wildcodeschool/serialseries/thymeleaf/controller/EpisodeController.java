package com.wildcodeschool.serialseries.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.serialseries.thymeleaf.repository.EpisodeRepository;

@Controller
public class EpisodeController {

	    @Autowired
	    private EpisodeRepository episodeRepo;

	    @GetMapping("/episode")
	    public String getAll(Model model) {

	        model.addAttribute("episodes", episodeRepo.findAll());
	        //model.addAttribute("series_name", seriesRepo.findAll());
	        return "episodes";
	     	}
	   
	    
	}
	

