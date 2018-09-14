package com.journaldev.retrofitintro;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

    @SerializedName("name")
    private String name;
    @SerializedName("main")
    private Main main;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("weather")
    private List<WeatherDescription> weatherDescription;

    public Weather(String name, Main main, Wind wind) {
        this.name = name;
        this.main = main;
        this.wind = wind;
    }


    public class Main {
        @SerializedName("temp")
        private double temp;
        @SerializedName("humidity")
        private int humidity;
        @SerializedName("pressure")
        private int pressure;

        public Main(double temp, int humidity, int pressure) {
            this.temp = temp;
            this.humidity = humidity;
            this.pressure = pressure;
        }

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }
    }


    public class Wind {
        @SerializedName("speed")
        private double speed;
        @SerializedName("deg")
        private int deg;

        public Wind(double speed, int deg) {
            this.speed = speed;
            this.deg = deg;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public int getDeg() {
            return deg;
        }

        public void setDeg(int deg) {
            this.deg = deg;
        }
    }

    public class WeatherDescription{
        @SerializedName("main")
        String mainDescription;

        public WeatherDescription(String mainDescription) {
            this.mainDescription = mainDescription;
        }

        public String getMainDescription() {
            return mainDescription;
        }

        public void setMainDescription(String mainDescription) {
            this.mainDescription = mainDescription;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public List<WeatherDescription> getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(List<WeatherDescription> weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
}
