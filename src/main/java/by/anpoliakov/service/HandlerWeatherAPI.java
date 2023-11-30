package by.anpoliakov.service;

import by.anpoliakov.pojo.MainPojo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HandlerWeatherAPI {

    public void test() {
        final RestTemplate restTemplate = new RestTemplate();
        final MainPojo stringPosts = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?lat=52.4238936&lon=31.0131698&lang=ru&appid=4270a714ea94f7a924a1d4dde25084e4&", MainPojo.class);
        System.out.println(stringPosts);
    }
}
