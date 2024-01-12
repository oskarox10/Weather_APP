package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping()
public class WeatherController {

    private RestTemplate restTemplate;
    private WeatherRepository weatherRepository;

    @Autowired
    private WeatherController (RestTemplate restTemplate, WeatherRepository weatherRepository) {
        this.restTemplate = restTemplate;
        this.weatherRepository = weatherRepository;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherEntity> getWeather (@PathVariable("city") String city){
        Optional<WeatherEntity> weather = weatherRepository.getWeather(city);

        if (weather.isPresent()) {
            return ResponseEntity.ok(weather.get());
        }
        return ResponseEntity.notFound().build();

    }










}
