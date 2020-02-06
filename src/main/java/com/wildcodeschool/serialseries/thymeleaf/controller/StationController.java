package com.wildcodeschool.serialseries.thymeleaf.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import com.wildcodeschool.serialseries.thymeleaf.entity.Station;
import com.wildcodeschool.serialseries.thymeleaf.repository.StationRepository;

@Controller
public class StationController {
	
    @Autowired
    private StationRepository repository;

    @GetMapping("/stations")
    public String getAll(Model model) {
        // Ausgabe des Inhalts der Stationliste (guter Test!!)
    	//List<Station> BugStation = repository.findAll();
    	//System.out.println(BugStation.size());
        model.addAttribute("stations", repository.findAll());
        
        return "stations";
     	}
}