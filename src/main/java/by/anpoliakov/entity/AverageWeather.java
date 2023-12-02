package by.anpoliakov.entity;

/** класс для отображения вычесленного среднего значения о погоде (по имеющимся данным в БД)
 * в интервале полученном во втором endpoint */
public class AverageWeather {
    /** средние значения погоды */
    private double average_temp;
    private double average_windSpeed;
    private double average_pressure;
    private double average_humidity;

    /** заданный интервал отображения */
    private LocalDateInterval interval;

    public AverageWeather() {
    }

    public AverageWeather(double aveTemp, double aveWindSpeed, double avePressure, double aveHumidity) {
        average_temp = aveTemp;
        average_windSpeed = aveWindSpeed;
        average_pressure = avePressure;
        average_humidity = aveHumidity;
    }

    public double getAverage_temp() {
        return average_temp;
    }

    public void setAverage_temp(double average_temp) {
        this.average_temp = average_temp;
    }

    public double getAverage_windSpeed() {
        return average_windSpeed;
    }

    public void setAverage_windSpeed(double average_windSpeed) {
        this.average_windSpeed = average_windSpeed;
    }

    public double getAverage_pressure() {
        return average_pressure;
    }

    public void setAverage_pressure(double average_pressure) {
        this.average_pressure = average_pressure;
    }

    public double getAverage_humidity() {
        return average_humidity;
    }

    public void setAverage_humidity(double average_humidity) {
        this.average_humidity = average_humidity;
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
                "average_temp=" + average_temp +
                ", average_windSpeed=" + average_windSpeed +
                ", average_pressure=" + average_pressure +
                ", average_humidity=" + average_humidity +
                ", interval=" + interval +
                '}';
    }
}
