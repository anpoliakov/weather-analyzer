package by.anpoliakov.service;

import by.anpoliakov.entity.Weather;
import by.anpoliakov.pojo.WeatherDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/** Сервис отвечающий за получение погоды через API,
 * преобразование данных в объект Weather
 * и вызов метода для записи этого объекта в базу даных **/
@Service
public class ScannerWeatherApiService {
    private final static Logger logger = LoggerFactory.getLogger(ScannerWeatherApiService.class);
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private WeatherService weatherService;

    @Value("${api.weather.url}")
    private String url;
    @Value("${api.weather.key}")
    private String key;
    @Value("${api.weather.city}")
    private String city;

    /** Выполнение метода происходит в отдельном пуле потоков,
     * вызов метода происходит с интервалом указанным в application.properties
     * через задачник Spring */
    @Async
    @Scheduled(fixedDelayString = "${api.weather.delay.scan}")
    protected void scanApi() {
        try {
            WeatherDataset dataset = restTemplate.getForObject(url, WeatherDataset.class, city, key);
            Weather weather = getWeather(dataset);
            logger.info("Получен объект погоды: \n" + weather);

            weatherService.addWeatherInDataBase(weather);
        }catch (ResourceAccessException e){
            logger.error("Проверьте подключение к интернету/корректность данных для подключения к API сервера" + url );
        }
    }

    /** Вычленение из набора данных - dataset, только данные необходимые для объекта Weather **/
    //TODO: добавить возможность указать в настрйоках properties, какие данные о погоде нас интересуют и динамически менять вывод
    private Weather getWeather(WeatherDataset dataset){
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
}
