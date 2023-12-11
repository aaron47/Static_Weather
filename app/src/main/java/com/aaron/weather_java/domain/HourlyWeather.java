package com.aaron.weather_java.domain;


public class HourlyWeather {
    private String hour;
    private int temp;
    private int imgResourceId;

    public HourlyWeather(String hour, int temp, int imgResourceId) {
        this.hour = hour;
        this.temp = temp;
        this.imgResourceId = imgResourceId;
    }

    public HourlyWeather() {}


    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    public void setImgResourceId(int imgResourceId) {
        this.imgResourceId = imgResourceId;
    }
}
