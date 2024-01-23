package by.anpoliakov.controller;

import by.anpoliakov.entity.WeatherEntity;
import by.anpoliakov.model.WeatherFilterRequest;
import by.anpoliakov.model.Views;
import by.anpoliakov.model.WeatherResponse;
import by.anpoliakov.repository.WeatherRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final static Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherRepository weatherRepository;

    /** first endpoint **/
    @GetMapping
    @JsonView(Views.DisplayInfo.class)
    public WeatherEntity getLastWeather(){
        return weatherRepository.findTopByOrderByDateDesc();
    }

    /** second endpoint **/
    @PostMapping
    public WeatherResponse getAverageWeatherValueByInterval(@RequestBody WeatherFilterRequest request){
        return weatherRepository.calculateAverage(request.getFrom().atStartOfDay(), request.getTo().atStartOfDay());
    }


}
