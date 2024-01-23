package by.anpoliakov.model.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class TemperatureApiResponse {
    private BigDecimal temp;
    private Integer pressure;
    private Integer humidity;
}
