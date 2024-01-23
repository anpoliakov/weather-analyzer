package by.anpoliakov.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class WeatherApiResponse {
    @JsonProperty("weather")
    private List<WeatherConditionApiResponse> weatherConditionApiResponses;
    @JsonProperty("main")
    private TemperatureApiResponse temperatureApiResponse;
    @JsonProperty("wind")
    private WindApiResponse windApiResponse;
    @JsonProperty("sys")
    private SystemApiResponse systemApiResponse;
    @JsonProperty(value = "name")
    private String nameLocation;
}
