package com.example.demo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
     "temp",
     "feels_like",
     "pressure",
     "clouds",
     "visibility"
})
public class WeatherEntity {

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("feels_like")
    private double feels_like;

    @JsonProperty("pressure")
    private int pressure;

    @JsonProperty("clouds")
    private int clouds;

    @JsonProperty("visibility")
    private int visibility;


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

    @JsonProperty("clouds")
    public int getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("visibility")
    public int getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
}
