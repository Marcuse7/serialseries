package com.wildcodeschool.serialseries.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.wildcodeschool.serialseries.thymeleaf.repository.StationRepository;

@Controller
public class StationController {
	
    @Autowired
    private StationRepository repository;

    @GetMapping("/stations")
    public String getAll(Model model) {

        model.addAttribute("stations", repository.findAll());

        return "stations";
     	}
}