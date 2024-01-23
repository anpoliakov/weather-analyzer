package by.anpoliakov.model.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SystemApiResponse {
    private String country;
    private int sunrise;
    private int sunset;
}
