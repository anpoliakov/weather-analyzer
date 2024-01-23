package by.anpoliakov.entity;

import by.anpoliakov.model.Views;
import by.anpoliakov.model.WeatherResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "weather")
@NamedNativeQuery( // аннотация для работы с нативным SQL запросом в @Query
        name = "WeatherEntity.calculateAverage",
        query = "SELECT AVG(temp) AS temp, AVG(wind_speed) AS windSpeed, " +
                "AVG(pressure) AS pressure, AVG(humidity) AS humidity " +
                "FROM weather WHERE date BETWEEN :from AND :to",
        resultSetMapping = "Mapping.Weather")

@SqlResultSetMapping( // аннотация для работы с нативным SQL запросом в @Query
        name="Mapping.Weather",
        classes = @ConstructorResult(
                targetClass = WeatherResponse.class,
                columns = {
                        @ColumnResult(name = "temp"),
                        @ColumnResult(name = "windSpeed"),
                        @ColumnResult(name = "pressure"),
                        @ColumnResult(name = "humidity")}))
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(Views.DisplayInfo.class)
    private BigDecimal temp;

    @JsonView(Views.DisplayInfo.class)
    private BigDecimal windSpeed;

    @JsonView(Views.DisplayInfo.class)
    private int pressure;

    @JsonView(Views.DisplayInfo.class)
    private int humidity;

    @JsonView(Views.DisplayInfo.class)
    private String weatherCondition;

    @JsonView(Views.DisplayInfo.class)
    private String location;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime date;

    public WeatherEntity(BigDecimal temp, BigDecimal windSpeed, int pressure, int humidity, String weatherCondition, String location, LocalDateTime date) {
        this.temp = temp;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weatherCondition = weatherCondition;
        this.location = location;
        this.date = date;
    }
}
