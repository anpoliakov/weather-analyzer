package by.anpoliakov.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Класс для десериализации второго endpoint от клиента (по заданию принимаем JSON)
 * для последующего вычисления среднего значения данных из базы данных, в указанном переуде времени
 */
@Setter
@Getter
@NoArgsConstructor
@Component
public class WeatherFilterRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("from")
    private LocalDate from;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("to")
    private LocalDate to;

    public WeatherFilterRequest(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }
}
