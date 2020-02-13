package com.wildcodeschool.serialseries.thymeleaf.controller;


import com.wildcodeschool.serialseries.thymeleaf.repository.SeriesRepository;
import com.wildcodeschool.serialseries.thymeleaf.repository.UserRepository;
import com.wildcodeschool.serialseries.thymeleaf.entity.User;
import com.wildcodeschool.serialseries.thymeleaf.entity.Series;

import javax.persistence.EntityManager;


import java.util.HashSet;
import java.util.Set;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SeriesController {
	
	@Autowired
    private SeriesRepository seriesRepository;

	@Autowired
	private EntityManager entityManager;

	@GetMapping("/series/all")
    public String showAllSeries(Model out) {
		
		
		out.addAttribute ("series", seriesRepository.findAll());
		
        return "series_all";
    }
	
	@GetMapping("/series/table")
    public String showAllSeriesTable(Model out) {
		
		
		out.addAttribute ("series", seriesRepository.findAll());
		
        return "series_table";
    }
	
	
	@GetMapping("/series/watch")
	@Transactional
	public String addSubscriber(@RequestParam String seriesID) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User loggedOnUser = (User) authentication.getPrincipal();

		Series series = findOne(seriesID);  // get Series object for the id from requestparam
		User user = (User) entityManager.merge(loggedOnUser); // get "non-detached" user object
		
		series.subscribe(user);

		return "series_all";
	}
	
	public Series findOne(String id) {
        return seriesRepository.findById(id).get();
        
    }    
}
