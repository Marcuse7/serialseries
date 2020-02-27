package com.wildcodeschool.serialseries.thymeleaf.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.wildcodeschool.serialseries.thymeleaf.entity.Schedule;
import com.wildcodeschool.serialseries.thymeleaf.entity.Station;
import com.wildcodeschool.serialseries.thymeleaf.repository.ScheduleRepository;
import com.wildcodeschool.serialseries.thymeleaf.repository.StationRepository;

@Controller
public class ScheduleController {

	@Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private StationRepository stationRepository;
    
    @GetMapping("/stations/schedule")
    public String getStations(Model modul) {

        modul.addAttribute("stations", stationRepository.findAll());
        return "stations";
    	}

    @GetMapping("/stations/findOne")
    public String inscription(Model modul,
                              @RequestParam(required = false) Integer id) {
    	
    	
        Optional<Station> optionalStation = stationRepository.findById(id);
        Station station = new Station();
        if (optionalStation.isPresent()) {
            station = optionalStation.get();
        	}
        
        // ChannelProgram
        modul.addAttribute("station", station);
        Schedule schedule = new Schedule();
        schedule.setStation(station);
        Example<Schedule> example = Example.of(schedule);
        modul.addAttribute("allSchedules", scheduleRepository.findAll(example));
        return "schedule";
    }   
}
