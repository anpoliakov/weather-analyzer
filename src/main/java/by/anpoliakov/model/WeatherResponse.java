package by.anpoliakov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class WeatherResponse {
    private BigDecimal temp;
    private BigDecimal windSpeed;
    private BigDecimal pressure;
    private BigDecimal humidity;

    public WeatherResponse() {}

    public WeatherResponse(BigDecimal temp, BigDecimal windSpeed, BigDecimal pressure, BigDecimal humidity) {
        this.temp = temp.setScale(2, BigDecimal.ROUND_DOWN);
        this.windSpeed = windSpeed.setScale(2, BigDecimal.ROUND_DOWN);
        this.pressure = pressure.setScale(2, BigDecimal.ROUND_DOWN);
        this.humidity = humidity.setScale(2, BigDecimal.ROUND_DOWN);
    }
}
