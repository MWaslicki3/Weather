package weather;

import config.Properties;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONArray;

public class WeatherAPIControl {
    public String getAPIString(String city, String country) {
        Properties prop = new Properties();
        String APIkey = prop.getAPIKey();
        String url = prop.getURL();
        String s = url + city + "," + country + "&key=" + APIkey;
        return s;
    }

    protected String getForecast(String URL) {
        String forecast = null;
        try {
            URL url = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                forecast = content.toString();
            } else {
                System.out.println("Failed to retrieve data. Response code: " + status);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return forecast;
    }

    protected Map<String, Object> getDataForValidDate(String jsonString, String validDate) {
        JSONObject weatherData = new JSONObject(jsonString);
        JSONArray dataArray = weatherData.getJSONArray("data");
        Map<String, Object> data = new HashMap<>();

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject dataPoint = dataArray.getJSONObject(i);

            if (dataPoint.getString("valid_date").equals(validDate)) {
                double windSpeed = dataPoint.getDouble("wind_spd");
                double temp = dataPoint.getDouble("temp");

                data.put("date", validDate);
                data.put("wind_speed", windSpeed);
                data.put("temperature", temp);

                break;
            }
        }
        return data;
    }
}
