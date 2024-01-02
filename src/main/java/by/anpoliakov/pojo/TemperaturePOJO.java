package by.anpoliakov.pojo;

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
    private float temp;
    @JsonProperty("feels_like")
    private float feelsLike;
    @JsonProperty("temp_min")
    private float tempMin;
    @JsonProperty("temp_max")
    private float tempMax;
    @JsonProperty("pressure")
    private Integer pressure;
    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("temp")
    public float getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(float temp) {
        this.temp = temp;
    }

    @JsonProperty("feels_like")
    public float getFeelsLike() {
        return feelsLike;
    }

    @JsonProperty("feels_like")
    public void setFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
    }

    @JsonProperty("temp_min")
    public float getTempMin() {
        return tempMin;
    }

    @JsonProperty("temp_min")
    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    @JsonProperty("temp_max")
    public float getTempMax() {
        return tempMax;
    }

    @JsonProperty("temp_max")
    public void setTempMax(float tempMax) {
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
