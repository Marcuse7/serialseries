package com.wildcodeschool.serialseries.thymeleaf.controller;


import com.wildcodeschool.serialseries.thymeleaf.repository.SeriesRepository;
import com.wildcodeschool.serialseries.thymeleaf.entity.User;
import com.wildcodeschool.serialseries.thymeleaf.entity.Series;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SeriesController {
	
	@Autowired
    private SeriesRepository seriesRepository;

	

	@GetMapping("/series/all")
    public String showAllSeries(Model out) {
		
		
		out.addAttribute ("series", seriesRepository.findAll());
		
        return "series_all";
    }
	
	@GetMapping("/series/watch")
	@Transactional
	public String addSubscriber(@RequestParam String seriesID) {
		
		System.out.println("SeriesID:" + seriesID);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		Series series = findOne(seriesID);
		
		Set<Series> subscriptions = user.getSubscriptions();
		
		System.out.println(subscriptions.toString());
		
//		user.getSubscriptions().add(series);
//		user.subscribe(series);
		
		return "series_all";
	}
	
	public Series findOne(String id) {
        return seriesRepository.findById(id).get();
        
    }    
}
