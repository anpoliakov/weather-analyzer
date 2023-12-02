package by.anpoliakov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author anpoliakov <it.anpoliakov@gmail.com>
 * @version 1.0
 *
 * Входная точка Spring Boot приложения
 * @EnableScheduling включаем возможность выполнения отложенных задач
 * @EnableAsync включаем возможность запускать @Async методы в отдельном пуле потоков
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class WeatherAnalyzerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeatherAnalyzerApplication.class, args);
    }

    /**
     * @return отдельный Executor, говорим что максимум 2 потока должны выполняться одновременно,
     * а размер очереди установлен на 5 (не столь важно в контексте данной задачи)
     */
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(5);
        executor.setThreadNamePrefix("JDAsync-");
        executor.initialize();
        return executor;
    }
}
