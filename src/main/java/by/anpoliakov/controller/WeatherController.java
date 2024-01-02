package by.anpoliakov.controller;

import by.anpoliakov.entity.LocalDateInterval;
import by.anpoliakov.entity.Views;
import by.anpoliakov.entity.Weather;
import by.anpoliakov.entity.WeatherAverage;
import by.anpoliakov.repo.WeatherRepository;
import by.anpoliakov.service.WeatherService;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final static Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherRepository weatherRepository;
    @Autowired
    private WeatherService weatherService;

    /** first endpoint **/
    @GetMapping()
    @JsonView(Views.DisplayInfo.class) // Устанавливаем своеобразный фильтр для вывода определённых полей пользователю
    public Weather getLastWeather(){
        return weatherRepository.findTopByOrderByDateDesc();
    }

    /** second endpoint **/
    @PostMapping()
    public WeatherAverage getAverageWeatherValueByInterval(@RequestBody LocalDateInterval localDateInterval){
        return weatherService.getAverageWeatherByInterval(localDateInterval);
    }


}
