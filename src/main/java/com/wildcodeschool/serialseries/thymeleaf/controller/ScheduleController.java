package com.wildcodeschool.serialseries.thymeleaf.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.serialseries.thymeleaf.entity.Episode;
import com.wildcodeschool.serialseries.thymeleaf.entity.Schedule;
import com.wildcodeschool.serialseries.thymeleaf.entity.Station;
import com.wildcodeschool.serialseries.thymeleaf.repository.EpisodeRepository;
import com.wildcodeschool.serialseries.thymeleaf.repository.ScheduleRepository;
import com.wildcodeschool.serialseries.thymeleaf.repository.StationRepository;

@Controller
public class ScheduleController {

	@Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private StationRepository stationRepository;
    
//    @Autowired
//    private EpisodeRepository episodeRepository;

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
        modul.addAttribute("station", station);
        Schedule schedule = new Schedule();
        schedule.setStation(station);
        Example<Schedule> example = Example.of(schedule);
        modul.addAttribute("allSchedules", scheduleRepository.findAll(example));
    //    modul.addAttribute("allSchedules", scheduleRepository.findById(id));
//
//        List<Schedule> schedulesNew = new ArrayList<>();
//        Method method = getMethod(station, "getSchedules", new Class[]{});
////        
//        if (method != null) {
//            try {
//                schedulesNew = (List<Schedule>) method.invoke(station);
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//        modul.addAttribute("stationSchedules", schedules);
      
//			        //EpsiodenTitle der TV Austrahlung
//			        @PostMapping("/stations/findOne/episode")
//        			public String episodeName(Model modulEpisode,@RequestParam(required = false)
//        			
//        			Optional<Episode> optionalEpisode = episodeRepository.findById(idStation);
//			        Episode episode = new Episode();
//			        if (optionalStation.isPresent()) {
//			            episode = optionalEpisode.get(Episode.this.setName(episodeName));
//			        }
//			        modul.addAttribute("Episode", episode);
//			        
			        
        
        return "schedule";
    }

//    @PostMapping("/stations/schedule")
//    public String inscription(@RequestParam String idStation,
//                              @RequestParam String idScshedule) {
//
//        Optional<Schedule> optionalSchedule = scheduleRepository.findById(idScshedule);
//        if (optionalSchedule.isPresent()) {
//            Schedule schedule = optionalSchedule.get();
//
//            Optional<Station> optionalStation = stationRepository.findById(idStation);
//            if (optionalStation.isPresent()) {
//                Station station = optionalStation.get();
//
//                Method method = getMethod(schedule, "setStation",
//                        new Class[]{Station.class});
//                if (method != null) {
//                    try {
//                        method.invoke(schedule, station);
//                    } catch (IllegalAccessException | InvocationTargetException e) {
//                        e.printStackTrace();
//                    }
//                }
//                scheduleRepository.save(schedule);
//            }
//        }
//
//        return "redirect:/station/schedule?idStation=" + idStation;
//    }

    public Method getMethod(Object obj, String methodName, Class[] args) {
        Method method;
        try {
            method = obj.getClass().getDeclaredMethod(methodName, args);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
//	 @Autowired
//	    private ScheduleRepository scheduleRepo;
//
//	    @GetMapping("/station/schedule")
//
//	    public String getAll(Model model) {
//
//	        model.addAttribute("scheduls", scheduleRepo.findAll());
//	        return "schedules";
//			}
	    
}
	    
