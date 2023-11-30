package by.anpoliakov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class WeatherAnalyzerApplication {
	public static void main(String[] args) {
		SpringApplication.run(WeatherAnalyzerApplication.class, args);
	}

	/**
	 * Здесь мы устанавливаем, что максимум 2 потока должны выполняться одновременно,
	 * а размер очереди установлен на 500 (Не столь важно в контексте данной задачи)
	 * **/
	@Bean
	public Executor asyncExecutor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500); //не столь важно сколько их будет максимально
		executor.setThreadNamePrefix("JDAsync-");
		executor.initialize();
		return executor;
	}
}
