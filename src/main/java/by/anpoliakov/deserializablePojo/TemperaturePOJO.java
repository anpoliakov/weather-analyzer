package by.anpoliakov.deserializablePojo;

import com.fasterxml.jackson.annotation.*;

/**
 * Класс для десериализацию блока JSON под ключом "main"
 * предоставляет информацию о: температуре, температуре ощущаемой/
 * минимальной/максимальной, давлении, влажности.
 * **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"temp", "feels_like", "temp_min", "temp_max", "pressure", "humidity"})
public class TemperaturePOJO {

    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("feels_like")
    private Double feelsLike;
    @JsonProperty("temp_min")
    private Double tempMin;
    @JsonProperty("temp_max")
    private Double tempMax;
    @JsonProperty("pressure")
    private Integer pressure;
    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("temp")
    public Double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @JsonProperty("feels_like")
    public Double getFeelsLike() {
        return feelsLike;
    }

    @JsonProperty("feels_like")
    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    @JsonProperty("temp_min")
    public Double getTempMin() {
        return tempMin;
    }

    @JsonProperty("temp_min")
    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    @JsonProperty("temp_max")
    public Double getTempMax() {
        return tempMax;
    }

    @JsonProperty("temp_max")
    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    @JsonProperty("pressure")
    public Integer getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "TemperaturePOJO{" +
                "temp=" + temp +
                ", feelsLike=" + feelsLike +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}
