package by.anpoliakov.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

/**
 * Основной класс для десериализацию JSON полученного
 * от внешнего сервиса openweathermap.org, представляет из себя
 * набор данных (dataset).
 * **/

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"weather", "main", "wind", "sys", "name"})
public class WeatherDataset {

    @JsonProperty("weather")
    private List<WeatherСonditionPOJO> weatherСonditionPOJO;
    @JsonProperty("main")
    private TemperaturePOJO temperaturePOJO;
    @JsonProperty("wind")
    private WindPOJO windPOJO;
    @JsonProperty("sys")
    private SystemPOJO systemPOJO;

    @JsonProperty("timezone")
    private Integer timezone;
    @JsonProperty("name")
    private String nameLocation;

    @JsonProperty("weather")
    public List<WeatherСonditionPOJO> getWeatherСonditionPOJO() {
        return weatherСonditionPOJO;
    }

    @JsonProperty("weather")
    public void setWeather(List<WeatherСonditionPOJO> weatherСonditionPOJO) {
        this.weatherСonditionPOJO = weatherСonditionPOJO;
    }

    @JsonProperty("main")
    public TemperaturePOJO getTemperaturePOJO() {
        return temperaturePOJO;
    }

    @JsonProperty("main")
    public void setTemperaturePOJO(TemperaturePOJO temperaturePOJO) {
        this.temperaturePOJO = temperaturePOJO;
    }

    @JsonProperty("wind")
    public WindPOJO getWindPOJO() {
        return windPOJO;
    }

    @JsonProperty("wind")
    public void setWindPOJO(WindPOJO windPOJO) {
        this.windPOJO = windPOJO;
    }

    @JsonProperty("sys")
    public SystemPOJO getSystemPOJO() {
        return systemPOJO;
    }

    @JsonProperty("sys")
    public void setSystemPOJO(SystemPOJO systemPOJO) {
        this.systemPOJO = systemPOJO;
    }

    @JsonProperty("timezone")
    public Integer getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("name")
    public String getNameLocation() {
        return nameLocation;
    }

    @JsonProperty("name")
    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    @Override
    public String toString() {
        return "DatasetWeather{" +
                "weatherСonditionPOJO=" + weatherСonditionPOJO +
                ", temperaturePOJO=" + temperaturePOJO +
                ", windPOJO=" + windPOJO +
                ", systemPOJO=" + systemPOJO +
                ", timezone=" + timezone +
                ", name='" + nameLocation + '\'' +
                '}';
    }
}
