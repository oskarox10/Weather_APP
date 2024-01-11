package com.example.demo;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

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
    public JsonNode findCoordinates (@PathVariable("city") String city) throws IOException {
        return geoCodingRepository.findCoordinatesByCity(city);
    }






}
