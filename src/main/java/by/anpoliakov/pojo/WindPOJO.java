package by.anpoliakov.pojo;

import com.fasterxml.jackson.annotation.*;

/**
 * Класс для десериализацию блока JSON под ключом "wind"
 * предоставляет информацию скорости ветра
 * **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"speed","deg","gust"})
public class WindPOJO {

    @JsonProperty("speed")
    private Integer speed;

    //два поля ниже - не особо интересуют в контексе данной задачи
    @JsonProperty("deg")
    private Integer deg;
    @JsonProperty("gust")
    private Integer gust;

    @JsonProperty("speed")
    public Integer getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @JsonProperty("deg")
    public Integer getDeg() {
        return deg;
    }

    @JsonProperty("deg")
    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    @JsonProperty("gust")
    public Integer getGust() {
        return gust;
    }

    @JsonProperty("gust")
    public void setGust(Integer gust) {
        this.gust = gust;
    }

    @Override
    public String toString() {
        return "WindPOJO{" +
                "speed=" + speed +
                ", deg=" + deg +
                ", gust=" + gust +
                '}';
    }
}
