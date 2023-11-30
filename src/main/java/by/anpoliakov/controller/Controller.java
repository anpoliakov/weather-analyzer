package by.anpoliakov.controller;

import by.anpoliakov.service.HandlerWeatherAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class Controller {
    @Autowired
    private HandlerWeatherAPI handlerWeatherAPI;

    @GetMapping
    public ResponseEntity getWeater(){
        try{
            return ResponseEntity.ok("Сервер работает!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/start")
    public void get(){
        handlerWeatherAPI.test();
    }
}
