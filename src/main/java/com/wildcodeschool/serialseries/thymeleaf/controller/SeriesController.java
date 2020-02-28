package com.wildcodeschool.serialseries.thymeleaf.controller;


import com.wildcodeschool.serialseries.thymeleaf.repository.EpisodeRepository;
import com.wildcodeschool.serialseries.thymeleaf.repository.SeriesRepository;
import com.wildcodeschool.serialseries.thymeleaf.entity.User;
import com.wildcodeschool.serialseries.thymeleaf.entity.Episode;
import com.wildcodeschool.serialseries.thymeleaf.entity.Series;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SeriesController {
	
	@Autowired
    private SeriesRepository seriesRepository;
	
	@Autowired
	private EpisodeRepository episodeRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	private void userSubscriptions(Model out) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User loggedOnUser = (User) authentication.getPrincipal();
		User user = (User) entityManager.merge(loggedOnUser); // get "non-detached" user object
		entityManager.refresh(user);
		Set<Series> subscriptions = user.getSubscriptions();
		out.addAttribute("subscriptions", subscriptions);
		
		out.addAttribute("user", user);
	}
	
	@GetMapping("/series/all")
	@Transactional
    public String showAllSeries(Model out) {
	

		String name="";
		String description=" ";

	 	out.addAttribute ("series", seriesRepository.findFirst30ByNameOrDescriptionContaining(name,description));

	 	
	 	userSubscriptions(out);
		
        return "series_all";
    }
	
	@GetMapping("/series/one")
	@Transactional
	public String showOneSeries(Model out, @RequestParam String seriesId) {
		
	
		
		Series series = seriesRepository.findById(seriesId).get();
		out.addAttribute ("series", series);  // Optional unwrap
		
		userSubscriptions(out);
		
		return "series_all";
		
	}
	
	@GetMapping("/series/page")
	@Transactional
	public String showAllSeriesPaged(@PageableDefault(size = 10) Pageable pageable, Model out) {
		
		Page<Series> page = seriesRepository.findAll(pageable);
		
		out.addAttribute ("page", page);
		
		userSubscriptions(out);
		
        return "series_page";
    }
	
	@GetMapping("/series/table")
	@Transactional
    public String showAllSeriesTable(Model out) {
			
		out.addAttribute ("series", seriesRepository.findAll());
		userSubscriptions(out);
		
        return "series_table";
    }
	
	@PostMapping("/series/search")
	@Transactional
    public String showSeriesByFilter(Model out, @RequestParam String suchbegriff) {
		userSubscriptions(out);
		out.addAttribute ("series", seriesRepository.findByNameOrDescriptionContaining(suchbegriff, suchbegriff));
        return "series_all";
    }
	
	
	@GetMapping("/series/subscribe")
	@Transactional
	public String addSubscriber(
		Model out, 
			@RequestParam String seriesId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User loggedOnUser = (User) authentication.getPrincipal();
		User user = (User) entityManager.merge(loggedOnUser); // get "non-detached" user object

		Series series = findOne(seriesId);  // get Series object for the id from requestparam
		
		series.subscribe(user);
		
		out.addAttribute ("series", series);

		
		

		return "series_all";
	}
	
	@GetMapping("/series/unsubscribe")
	@Transactional
	public String removeSubscriber(@RequestParam String seriesId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User loggedOnUser = (User) authentication.getPrincipal();
		User user = (User) entityManager.merge(loggedOnUser); // get "non-detached" user object
		
		Series series = findOne(seriesId);  // get Series object for the id from requestparam
		
		series.unSubscribe(user);
		
		return "series_all";
	}
	
	public Series findOne(String id) {
        return seriesRepository.findById(id).get();
        
    }
	

}
