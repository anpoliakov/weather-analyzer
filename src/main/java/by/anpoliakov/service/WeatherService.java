package by.anpoliakov.service;

import by.anpoliakov.entity.LocalDateInterval;
import by.anpoliakov.entity.Weather;
import by.anpoliakov.entity.WeatherAverage;
import by.anpoliakov.repo.WeatherRepository;
import by.anpoliakov.service.ScannerWeatherApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/** Сервис содержащий логику работы с объектом Weather */
@Service
public class WeatherService {
    private final static Logger logger = LoggerFactory.getLogger(ScannerWeatherApiService.class);

    @Autowired
    private WeatherRepository weatherRepository;

    /** Метод отвечающий за добавление объекта Weather в БД */
    public void addWeatherInDataBase(Weather weather){
        Weather weatherSaved = weatherRepository.save(weather);

        if(weatherRepository.existsById(weatherSaved.getId())){
            logger.info("Объект Weather был записан в Data Base!");
        }
    }

    /** @param localDateInterval десериализацованный пользовательский JSON
     *  представляет из себя начало и конец промежутка, в котором необходимо получить
     *  среднесуточный обьект (содержащий среднесуточные значения)
     *  @return AverageWeather - объект с среднесуточными значениями */
    public WeatherAverage getAverageWeatherByInterval(LocalDateInterval localDateInterval){
        LocalDate fromDate = localDateInterval.getFromDate();
        LocalDate toDate = localDateInterval.getToDate();

        WeatherAverage weatherAverage = weatherRepository.findAverageTempByInterval(fromDate, toDate);
        weatherAverage.setInterval(localDateInterval);

        return weatherAverage;
    }
}
