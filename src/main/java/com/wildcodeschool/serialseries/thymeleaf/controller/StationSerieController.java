package com.wildcodeschool.serialseries.thymeleaf.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.serialseries.thymeleaf.entity.Series;
import com.wildcodeschool.serialseries.thymeleaf.entity.Station;
import com.wildcodeschool.serialseries.thymeleaf.repository.SeriesRepository;
import com.wildcodeschool.serialseries.thymeleaf.repository.StationRepository;

@Controller
public class StationSerieController {

    @Autowired
    private StationRepository stationRepo;

    @Autowired
    private SeriesRepository seriesRepo;

    @GetMapping("/stations/1")
    public String getStation(Model out) {

        out.addAttribute("stations", stationRepo.findAll());
        return "stations";
    }

    @GetMapping("/stations/1/stationsSeries")
    public String inscription(Model out,
                              @RequestParam String station_id) {

        Optional<Station> optionalStation = stationRepo.findById(station_id);
        Station station = new Station();
        if (optionalStation.isPresent()) {
            station = optionalStation.get();
        }
        out.addAttribute("station", station);
        out.addAttribute("allSeries", seriesRepo.findAll());

        // call the method getSeries in Station
        List<Series> series = new ArrayList<>();
        Method method = getMethod(station, "getSeries",
                new Class[]{});
        if (method != null) {
            try {
                series = (List<Series>) method.invoke(station);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println(series);
        out.addAttribute("stationSeries", series);

        return "serie";
    }

    @PostMapping("/stations/1/stationsSeries")
    public String inscription(@RequestParam String station_id,
                              @RequestParam String idSeries) {

        Optional<Series> optionalSerie = seriesRepo.findById(idSeries);
        if (optionalSerie.isPresent()) {
            Series serie = optionalSerie.get();

            Optional<Station> optionalStation = stationRepo.findById(station_id);
            if (optionalStation.isPresent()) {
                Station station = optionalStation.get();

                // call the method setSchool in Wizard
                Method method = getMethod(serie, "setStation",
                        new Class[]{Station.class});
                if (method != null) {
                    try {
                        method.invoke(serie, station);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                seriesRepo.save(serie);
            }
        }

        return "redirect:/station/1/register?idStation=" + station_id;
    }

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
}
