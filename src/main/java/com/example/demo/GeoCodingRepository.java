package com.example.demo;


import org.springframework.stereotype.Repository;

@Repository
public class GeoCodingRepository {

    private final String GeoCodingURL = "http://api.openweathermap.org/geo/1.0/direct?q=";

    public String findCoordinatesByCity(String City){

    }



}
