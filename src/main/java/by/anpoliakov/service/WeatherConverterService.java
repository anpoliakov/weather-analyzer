package by.anpoliakov.service;

import by.anpoliakov.entity.WeatherEntity;
import by.anpoliakov.model.api.WeatherApiResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class WeatherConverterService {

    public WeatherEntity convertToWeatherEntity(WeatherApiResponse response){
        BigDecimal temp = response.getTemperatureApiResponse().getTemp();
        BigDecimal windSpeed = response.getWindApiResponse().getSpeed();
        Integer pressure = response.getTemperatureApiResponse().getPressure();
        Integer humidity = response.getTemperatureApiResponse().getHumidity();
        String location = response.getNameLocation();
        LocalDateTime localDateTime = LocalDateTime.now();
        String condition = response.getWeatherConditionApiResponses().get(0).getDescription();

        return new WeatherEntity(temp, windSpeed, pressure, humidity, condition, location, localDateTime);
    }

}
