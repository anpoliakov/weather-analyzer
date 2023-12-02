package by.anpoliakov.repo;

import by.anpoliakov.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/** интерфейс предоставляющий методы для обращения к БД */
@Repository
public interface WeatherRepo extends JpaRepository<Weather,Long> {
    //@Query(value = "SELECT * FROM weather ORDER BY date DESC LIMIT 1", nativeQuery = true)
    //Weather findLastAddedDataWeather();

    /** методы которых нет в стандартном списке при обращении к БД */
    Weather findTopByOrderByDateDesc();
    List<Weather> findAllByDateBetween(LocalDateTime from, LocalDateTime to);
}
