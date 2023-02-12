package weather;

import java.util.Date;

public class WeatherAPI {
    String country;
    String city;
    String forecastDate;
    public WeatherAPI(String city, String country, String forecastDate){
        this.city = city;
        this.country = country;
        this.forecastDate = forecastDate;
    }


}
