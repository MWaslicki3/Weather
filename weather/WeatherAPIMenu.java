package weather;

import java.util.Map;
import java.util.HashMap;

public class WeatherAPIMenu {
    private WeatherAPIControl WeatherAPIControl;

    public WeatherAPIMenu(WeatherAPIControl WeatherAPIControl){
        this.WeatherAPIControl = WeatherAPIControl;
    }

    public Map<String, Object> getForecast(String city, String country, String validDate){
        Map<String, Object> forecastData = new HashMap<>();
        String URL = WeatherAPIControl.getAPIString(city, country);
        String json = WeatherAPIControl.getForecast(URL);
        forecastData = WeatherAPIControl.getDataForValidDate(json,validDate);
        return forecastData;
    }
}
