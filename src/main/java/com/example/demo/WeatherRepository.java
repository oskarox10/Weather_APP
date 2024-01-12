package com.example.demo;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository
public class WeatherRepository {

    private final String GeoCodingURL = "http://api.openweathermap.org/geo/1.0/direct?q=";
    private final String WeatherURL = "https://api.openweathermap.org/data/2.5/weather?lat=";

    @Value("${apiKey}")
    private String apiKey;


    private ObjectMapper objectMapper;
    private RestTemplate restTemplate;

    @Autowired
    private WeatherRepository(RestTemplate restTemplate, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper=objectMapper;
    }


    private Map<String,Double> findCoordinatesByCity(String City) {
        Optional<JsonNode> jsonNode = Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(GeoCodingURL + City + "&limit=5&appid=" + apiKey, JsonNode[].class))).findFirst();

        Map<String, Double> result = new HashMap<>();

        if (jsonNode.isPresent()){
            double lat = jsonNode.get().get("lat").asDouble();
            double lon = jsonNode.get().get("lon").asDouble();
            result.put("lat", lat);
            result.put("lon", lon);

            return result;

        }else {
            throw new RuntimeException("null");
        }
    }


    public Optional<WeatherEntity> getWeather(String City){
        Map<String, Double> coordinates = findCoordinatesByCity(City);

        return Optional.ofNullable(restTemplate.getForObject(WeatherURL + coordinates.get("lat") + "&lon=" + coordinates.get("lon")+"&appid=" + apiKey, WeatherEntity.class));
    }








}
