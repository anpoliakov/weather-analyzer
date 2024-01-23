package by.anpoliakov.service;

import by.anpoliakov.config.WeatherConfig;
import by.anpoliakov.entity.WeatherEntity;
import by.anpoliakov.model.api.WeatherApiResponse;
import by.anpoliakov.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherLoaderSchedulerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(WeatherLoaderSchedulerService.class);
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private WeatherConfig weatherConfig;

    @Autowired
    private WeatherConverterService weatherConverterService;

    @Scheduled(fixedDelayString = "${api.weather.delay.scan}")
    protected void scanApi() {
        try {
            WeatherApiResponse weatherApiResponse =
                    restTemplate.getForObject(
                        weatherConfig.getUrl(),
                        WeatherApiResponse.class,
                        weatherConfig.getCity(),
                        weatherConfig.getKey());

            if(weatherApiResponse == null){
                LOGGER.warn("Unable to save weather API response: empty response");
            }else {
                WeatherEntity weatherEntity = weatherConverterService.convertToWeatherEntity(weatherApiResponse);
                weatherRepository.save(weatherEntity);
            }

        }catch (ResourceAccessException e){
            LOGGER.error("Unable to execute weather API: {}", weatherConfig.getUrl());
        }
    }
}
