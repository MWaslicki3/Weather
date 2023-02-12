package weather;

import java.util.ArrayList;
import java.util.List;

public class LocationData {
    private static List<Location> locationList;

    static {
        locationList = new ArrayList<>();
        locationList.add(new Location("Poland", "Jastarnia", 12.5, 20));
        locationList.add(new Location("Barbados", "Bridgetown", 14.3, 25));
        locationList.add(new Location("Brazil", "Fortaleza", 16.1, 30));
        locationList.add(new Location("Cyprus", "Pissouri", 8.2, 18));
        locationList.add(new Location("Mauritius", "Le Morne", 11.4, 22));
    }

    public static List<Location> getLocationList() {
        return locationList;
    }

    public static void addLocation(Location location) {
        locationList.add(location);
    }

    public static void updateLocation(Location location, String country, String city, double windSpeed, double temperature) {
        location.setCountry(country);
        location.setCity(city);
        location.setWindSpeed(windSpeed);
        location.setTemperature(temperature);
    }

    public static void deleteLocation(Location location) {
        locationList.remove(location);
    }
}
