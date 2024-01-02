package by.anpoliakov.entity;

/** класс для отображения вычесленного среднего значения о погоде (по имеющимся данным в БД)
 * в интервале полученном во втором endpoint */
public class WeatherAverage {
    /** средние значения погоды */
    private float averageTemp;
    private float averageWindSpeed;
    private float averagePressure;
    private float averageHumidity;

    /** заданный интервал отображения */
    private LocalDateInterval interval;

    public WeatherAverage() {
    }

    public float getAverageTemp() {
        return averageTemp;
    }

    public void setAverageTemp(float averageTemp) {
        this.averageTemp = averageTemp;
    }

    public float getAverageWindSpeed() {
        return averageWindSpeed;
    }

    public void setAverageWindSpeed(float averageWindSpeed) {
        this.averageWindSpeed = averageWindSpeed;
    }

    public float getAveragePressure() {
        return averagePressure;
    }

    public void setAveragePressure(float averagePressure) {
        this.averagePressure = averagePressure;
    }

    public float getAverageHumidity() {
        return averageHumidity;
    }

    public void setAverageHumidity(float averageHumidity) {
        this.averageHumidity = averageHumidity;
    }

    public LocalDateInterval getInterval() {
        return interval;
    }

    public void setInterval(LocalDateInterval interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "AverageWeather{" +
                "average_temp=" + averageTemp +
                ", average_windSpeed=" + averageWindSpeed +
                ", average_pressure=" + averagePressure +
                ", average_humidity=" + averageHumidity +
                ", interval=" + interval +
                '}';
    }
}
