package weather;
import java.util.List;

class Location {
    private String country;
    private String city;
    private double windSpeed;
    private double temperature;

    public Location(String country, String city, double windSpeed, double temperature) {
        this.country = country;
        this.city = city;
        this.windSpeed = windSpeed;
        this.temperature = temperature;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}