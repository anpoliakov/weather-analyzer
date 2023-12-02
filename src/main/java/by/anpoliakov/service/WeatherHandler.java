package by.anpoliakov.service;

import by.anpoliakov.entity.LocalDateInterval;
import by.anpoliakov.entity.Weather;
import by.anpoliakov.entity.AverageWeather;
import by.anpoliakov.deserializablePojo.DeserializerWeatherDataset;
import by.anpoliakov.repo.WeatherRepo;
import org.apache.commons.math3.util.Precision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/** сервис отвечающий за обработку данных от внешнего API погоды,
 * так же за обрабтку полученных данных при записи в бд,
 * обработку логики из единственного контроллера */
@Service
public class WeatherHandler {
    private final static Logger logger = LoggerFactory.getLogger(BackgroundScannerApi.class);

    @Autowired
    private WeatherRepo weatherRepo;

    /** метод отвечающий за запись погоды в БД */
    public void addWeatherInDataBase(DeserializerWeatherDataset dataset){
        weatherRepo.save(transformDatasetToWeather(dataset));
        logger.info("Объект Weather был записан в Data Base!");
    }

    /**
     * @Param dataset - объект содержащий грубые данные из JSON от внешнего API погоды
     * @return обьект Weather (без мусора c добавленным параметром даты и времени)
     * **/
    private Weather transformDatasetToWeather(DeserializerWeatherDataset dataset){
        Weather weather = new Weather();
        weather.setTemp(dataset.getTemperaturePOJO().getTemp());
        weather.setWindSpeed(dataset.getWindPOJO().getSpeed());
        weather.setPressure(dataset.getTemperaturePOJO().getPressure());
        weather.setHumidity(dataset.getTemperaturePOJO().getHumidity());
        weather.setWeatherCondition(dataset.getWeatherСonditionPOJO().get(0).getDescription());
        weather.setLocation(dataset.getNameLocation());
        weather.setDate(LocalDateTime.now());
        return weather;
    }

    /** @param localDateInterval десериализацованный пользовательский JSON
     *  представляет из себя начало и конец промежутка, в котором необходимо получить
     *  среднесуточный обьект (содержащий среднесуточные значения)
     *  @return AverageWeather - объект с среднесуточными значениями */
    public AverageWeather getAveWeatherByLocalDateInterval(LocalDateInterval localDateInterval){
        LocalDate fromDate = localDateInterval.getFromDate();
        LocalDate toDate = localDateInterval.getToDate();

        AverageWeather averageWeather = getAverageWeather(weatherRepo.findAllByDateBetween(fromDate.atStartOfDay(), toDate.atStartOfDay()));
        averageWeather.setInterval(localDateInterval);
        return averageWeather;
    }

    /** @param list объектов полученных из DB по интервалу
     *  @return расчитанный среднесуточный объект */
    private AverageWeather getAverageWeather(List <Weather> list){
        int rounding = 3;
        double aveTemp = Precision.round(list.stream().mapToDouble(Weather::getTemp).average().getAsDouble(),rounding);
        double aveWindSpeed = Precision.round(list.stream().mapToInt(Weather::getWindSpeed).average().getAsDouble(),rounding);
        double avePressure = Precision.round(list.stream().mapToInt(Weather::getPressure).average().getAsDouble(),rounding);
        double aveHumidity = Precision.round(list.stream().mapToInt(Weather::getHumidity).average().getAsDouble(),rounding);

        return new AverageWeather(aveTemp, aveWindSpeed, avePressure, aveHumidity);
    }

}
