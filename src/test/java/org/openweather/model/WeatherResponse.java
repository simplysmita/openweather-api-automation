package org.openweather.model;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {
    private Coordinates coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private Long visibility;
    private Wind wind;
    private Clouds clouds;
    private Long dt;
    private Sys sys;
    private Long timezone;
    private Long id;
    private String name;
    private Integer cod;
}
