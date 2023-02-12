package config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Properties {
    private final String apiKey = System.getenv("Weather_API");
    private final String url = "https://api.weatherbit.io/v2.0/forecast/daily?city=";
    private Map<String, String> forecastLocations = new HashMap<>();

    public String getAPIKey() {
        return apiKey;
    }
    public String getURL() {
        return url;
    }

    public void initForecastLocations(){
        forecastLocations.put("Jastarnia","PL");
        forecastLocations.put("Bridgetown","Barbados");
        forecastLocations.put("Fortaleza","Brazil");
        forecastLocations.put("Pissouri","Cyprus");
    }
    public void addForecastLocations(String city, String country){
        forecastLocations.put(city, country);
    }

    public String getLocationByCity(String city){
        return forecastLocations.get(city);
    }

    public Map getLocations(){
        return forecastLocations;
    }
}
