package com.example.demo;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

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


    public JsonNode findCoordinatesByCity(String City) throws IOException {
        JsonNode json;

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(GeoCodingURL + City + "&limit=5&appid=fc020e00e72e06c98a1095659064252b");
        json = objectMapper.readValue(inputStream, JsonNode.class);

        JsonNode lat = getLat(json);

        return lat;

    }

    private JsonNode getLat(JsonNode json) {
        return Optional.ofNullable(json)
                .map(jsonNode -> jsonNode.get("lon"))
                .orElseThrow(() -> new RuntimeException("Invalid Jon"));

    }


}
