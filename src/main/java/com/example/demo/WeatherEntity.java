package com.example.demo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sun.tools.javac.Main;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
     "temp",
     "feels_like",
     "pressure"
})
public class WeatherEntity {

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("feels_like")
    private double feels_like;

    @JsonProperty("pressure")
    private int pressure;



    @JsonProperty("temp")
    public double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(double temp) {
        this.temp = temp;
    }

    @JsonProperty("feels_like")
    public double getFeels_like() {
        return feels_like;
    }

    @JsonProperty("feels_like")
    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    @JsonProperty("pressure")
    public int getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

}
