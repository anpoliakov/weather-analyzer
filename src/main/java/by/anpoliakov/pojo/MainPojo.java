package by.anpoliakov.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "weather",
        "main",
        "wind",
        "sys",
        "timezone",
        "id",
        "name",
        "cod"
})
public class MainPojo {

    @JsonProperty("weather")
    private List<Weather> weather;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("timezone")
    private Integer timezone;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private Integer cod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("weather")
    public List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @JsonProperty("sys")
    public Sys getSys() {
        return sys;
    }

    @JsonProperty("sys")
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @JsonProperty("timezone")
    public Integer getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("cod")
    public Integer getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(Integer cod) {
        this.cod = cod;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "MainPojo{" +
                "weather=" + weather +
                ", main=" + main +
                ", wind=" + wind +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
