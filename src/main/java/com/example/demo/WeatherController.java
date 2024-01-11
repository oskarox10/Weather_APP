package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping()
public class WeatherController {

    private RestTemplate restTemplate;
    private GeoCodingRepository geoCodingRepository;

    @Autowired
    private WeatherController (RestTemplate restTemplate, GeoCodingRepository geoCodingRepository) {
        this.restTemplate = restTemplate;
        this.geoCodingRepository = geoCodingRepository;
    }


    @GetMapping("/coordinates/{city}")
    public ResponseEntity<Coordinates> findCoordinates (@PathVariable("city") String city){
        return geoCodingRepository.findCoordinatesByCity(city);
    }






}