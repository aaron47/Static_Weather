package com.aaron.weather_java.domain;


public class FutureWeather {
    private String day;
    private int imgResourceId;
    private String status;
    private int highTemp;
    private int lowTemp;

    public FutureWeather(String day, int imgResourceId, String status, int highTemp, int lowTemp) {
        this.day = day;
        this.imgResourceId = imgResourceId;
        this.status = status;
        this.highTemp = highTemp;
        this.lowTemp = lowTemp;
    }

    public FutureWeather() {}

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    public void setImgResourceId(int imgResourceId) {
        this.imgResourceId = imgResourceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(int highTemp) {
        this.highTemp = highTemp;
    }

    public int getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(int lowTemp) {
        this.lowTemp = lowTemp;
    }
}