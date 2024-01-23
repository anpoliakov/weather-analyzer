package by.anpoliakov.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api.weather")
public class WeatherConfig {
    private String url;
    private String key;
    private String city;

    public String getUrl() {
        return url;
    }

    public String getKey() {
        return key;
    }

    public String getCity() {
        return city;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
