package by.anpoliakov.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Weather {
    @Id
    @GeneratedValue
    private Long id;

    /** Температура воздуха */
    @JsonView(Views.DisplayInfo.class)
    private double temp;

    /** Скорость ветра, м/ч */
    @JsonView(Views.DisplayInfo.class)
    @JoinColumn(name = "wind_speed")
    private int windSpeed;

    /** Атмосферное давление, гПа */
    @JsonView(Views.DisplayInfo.class)
    private int pressure;

    /** Влажность воздуха, % */
    @JsonView(Views.DisplayInfo.class)
    private int humidity;

    /** Погодные условия */
    @JsonView(Views.DisplayInfo.class)
    @JoinColumn(name = "weather_condition")
    private String weatherCondition;

    /** Локация */
    @JsonView(Views.DisplayInfo.class)
    private String location;

    /** Дата и время */
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime date;

    public Weather() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Погода - "+ location +" {\n" +
                "темература = " + temp + " градусов Цельсия\n" +
                ", скорость ветра = " + windSpeed + " м/c\n" +
                ", атмосферное давление =" + pressure + " гПа\n" +
                ", влажность воздуха = " + humidity + " %\n" +
                ", погодные условия = " + weatherCondition + "\n"+
                ", дата и время прогноза =" + date + '}';
    }
}
