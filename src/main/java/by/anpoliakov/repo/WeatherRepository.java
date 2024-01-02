package by.anpoliakov.repo;

import by.anpoliakov.entity.Weather;
import by.anpoliakov.entity.WeatherAverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/** Интерфейс c методами для обращения к БД */
@Repository
public interface WeatherRepository extends JpaRepository<Weather,Long> {
    Weather findTopByOrderByDateDesc();

    @Query(value = "SELECT AVG(temp) AS averageTemp, AVG(wind_speed) AS averageWindSpeed, AVG(pressure) AS averagePressure, AVG(humidity) AS averageHumidity FROM weather WHERE date BETWEEN :fromDate AND :toDate", nativeQuery = true)
    WeatherAverage findAverageTempByInterval(LocalDate fromDate, LocalDate toDate);
}
