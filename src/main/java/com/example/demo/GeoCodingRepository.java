package com.example.demo;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Repository
public class GeoCodingRepository {

    private final String GeoCodingURL = "http://api.openweathermap.org/geo/1.0/direct?q=";


    private ObjectMapper objectMapper;
    private RestTemplate restTemplate;

    @Autowired
    private GeoCodingRepository(RestTemplate restTemplate, ObjectMapper objectMapper){
        this.restTemplate = restTemplate;
        this.objectMapper=objectMapper;
    }


    public Map<String,Integer> findCoordinatesByCity(String City) {
        Optional<JsonNode> jsonNode = Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(GeoCodingURL + City + "&limit=5&appid=fc020e00e72e06c98a1095659064252b", JsonNode[].class))).findFirst();

        Map<String, Integer> result = new HashMap<>();

        if (jsonNode.isPresent()){
            int lat = jsonNode.get().get("lat").asInt();
            int lon = jsonNode.get().get("lon").asInt();
            result.put("lat", lat);
            result.put("lon", lon);

            return result;

        }else {
            throw new RuntimeException("null");
        }
    }


}
