package by.anpoliakov.service;

import by.anpoliakov.deserializablePojo.DeserializerWeatherDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Сервис отвечающий за фоновую работу метода, опрашивающего API погоды
 * после десериализации JSON получаем набор данных, который представляет
 * из себя класс:
 * @see DeserializerWeatherDataset
 * **/
@Service
public class BackgroundScannerApi {
    private final static Logger logger = LoggerFactory.getLogger(BackgroundScannerApi.class);

    @Autowired
    private WeatherHandler weatherHandler;

    /** значение переменных, получаем из application.properties */
    @Value("${api.weather.url}")
    private String url;
    @Value("${api.weather.key}")
    private String key;
    @Value("${api.weather.city}")
    private String city;

    // В тестовом задании использовал RestTemplate, но лучшее решение - WebClient
    private RestTemplate restTemplate = new RestTemplate();

    /** Выполнение метода происходит в отдельном пуле потоков,
     * вызов метода происходит с интервалом указанным в application.properties
     * через задачник Spring */
    @Async
    @Scheduled(fixedDelayString = "${api.weather.delay.scan}")
    public void scanApi() {
        DeserializerWeatherDataset dataset = restTemplate.getForObject(url, DeserializerWeatherDataset.class, city, key);
        logger.info("Десериализован ответ API Weather: " + dataset.toString());
        weatherHandler.addWeatherInDataBase(dataset);
    }
}
