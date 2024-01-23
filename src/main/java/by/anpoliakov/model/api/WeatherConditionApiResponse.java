package by.anpoliakov.model.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WeatherConditionApiResponse {
    private String main;
    private String description;
}
