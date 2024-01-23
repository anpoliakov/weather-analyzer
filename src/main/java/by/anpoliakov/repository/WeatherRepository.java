package by.anpoliakov.repository;

import by.anpoliakov.entity.WeatherEntity;
import by.anpoliakov.model.WeatherResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/** Интерфейс c методами для обращения к БД */

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity,Long> {
    WeatherEntity findTopByOrderByDateDesc();

    //SQL команда и маппинг результата лежит в WeatherEntity
    @Query(nativeQuery = true)
    WeatherResponse calculateAverage(LocalDateTime from, LocalDateTime to);
}
