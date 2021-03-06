package com.wildcodeschool.serialseries.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wildcodeschool.serialseries.thymeleaf.entity.Station;
import com.wildcodeschool.serialseries.thymeleaf.repository.StationRepository;

@Controller
public class StationController {
	
    @Autowired
    private StationRepository stationRepo;

    @GetMapping("/stations")

    public String getAll(Model model,
    						@RequestParam(defaultValue = "0") int page) {

        model.addAttribute("stations", stationRepo.findAll());
        //model.addAttribute("series_name", seriesRepo.findAll());

        model.addAttribute("currentPage", page);
        return "stations";
     	
    }
   
    
        @GetMapping("/findOne")
        @ResponseBody
        public Station findOne(Integer id) {
            return stationRepo.findById(id).get(); 
        	}
        
        @GetMapping("/search")
        public String search(Model model, @RequestParam String name) {
      		model.addAttribute("stations", stationRepo.findByNameContaining(name));
      		return "/stations";

      	}
        
//        @GetMapping("/stations")
//        public String countryName(Expense expense,Model model){
//            model.addAttribute("c",categoryRepo.findAll());
//            return "stations";
//        }
        

        
        
}