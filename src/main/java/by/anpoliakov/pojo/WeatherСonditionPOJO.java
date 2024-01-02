package by.anpoliakov.pojo;

import com.fasterxml.jackson.annotation.*;

/**
 * Класс для десериализацию блока JSON под ключом "weather"
 * предоставляет информацию о погодных условиях
 * **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"main","description"})
public class WeatherСonditionPOJO {

    @JsonProperty("main")
    private String main;
    @JsonProperty("description")
    private String description;

    @JsonProperty("main")
    public String getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(String main) {
        this.main = main;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WeatherСonditionPOJO{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
