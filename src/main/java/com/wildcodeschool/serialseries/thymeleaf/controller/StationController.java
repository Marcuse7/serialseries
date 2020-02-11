package com.wildcodeschool.serialseries.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import com.wildcodeschool.serialseries.thymeleaf.entity.Episode;
//import com.wildcodeschool.serialseries.thymeleaf.entity.Schedule;
import com.wildcodeschool.serialseries.thymeleaf.entity.Station;
//import com.wildcodeschool.serialseries.thymeleaf.entity.Series;
//import com.wildcodeschool.serialseries.thymeleaf.repository.SeriesRepository;
import com.wildcodeschool.serialseries.thymeleaf.repository.StationRepository;

@Controller
public class StationController {
	
    @Autowired
    private StationRepository stationRepo;
    //private SeriesRepository  seriesRepo;

    @GetMapping("/stations")
    public String getAll(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("stations", stationRepo.findAll(PageRequest.of(page, 6)));
        //model.addAttribute("series_name", seriesRepo.findAll());
        model.addAttribute("currentPage", page);
        return "stations";
     	
    }
        @GetMapping("/findOne")
        @ResponseBody
        public Station findOne(Integer id) {
            return stationRepo.findById(id).get();
            
        }       
}

        
        //       @GetMapping("/findOne")
//       @ResponseBody
//       return StationRepository.findById(id).get();
////   public String getAlEpsiode(Model model) {
////	model.addAllAttributes("findone,")   	
//    	return findOne;
    	
    
//    public Episode findOne(long id) {
//    	return Episode.class.getField("episode_id");
//    	Cannot make a static reference to the non-static method findById(Long) from the type 
//        return StationRepository.findById(id).get();

    
