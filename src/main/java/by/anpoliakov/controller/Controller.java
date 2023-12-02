package by.anpoliakov.controller;

import by.anpoliakov.entity.LocalDateInterval;
import by.anpoliakov.entity.Views;
import by.anpoliakov.entity.Weather;
import by.anpoliakov.entity.AverageWeather;
import by.anpoliakov.repo.WeatherRepo;
import by.anpoliakov.service.WeatherHandler;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class Controller {
    private final static Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private WeatherRepo weatherRepo;
    @Autowired
    private WeatherHandler weatherHandler;

    /**
     * по GET запросу на адресс /weather
     * @return Weather обьект в виде JSON
     * последний, который был добавлен в БД
     * **/
    @GetMapping()
    /** Устанавливаем своеобразный фильтр для вывода определённых полей пользователю **/
    @JsonView(Views.DisplayInfo.class)
    public Weather getLastWeatherFromDataBase(){
        return weatherRepo.findTopByOrderByDateDesc();
    }

    /**
     * по POST запросу на адресс /weather
     * @return ???
     * **/
    @PostMapping()
    public AverageWeather getAveInfo(@RequestBody LocalDateInterval localDateInterval){
        return weatherHandler.getAveWeatherByLocalDateInterval(localDateInterval);
    }


}
