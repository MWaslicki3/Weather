package weather;

import config.Properties;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Properties prop = new Properties();

        prop.initForecastLocations();
        WeatherAPIControl API = new WeatherAPIControl();
        WeatherAPIMenu APImenu = new WeatherAPIMenu(API);

        Map<String, String> forecastLocations = prop.getLocations();
        for (Map.Entry<String, String> entry : forecastLocations.entrySet()) {
            WeatherAPI weather = new WeatherAPI(entry.getKey(), entry.getValue(), "2023-02-12");
            System.out.println(entry.getKey());
            System.out.println(APImenu.getForecast(weather.city, weather.country, weather.forecastDate));
        }

    }


}
