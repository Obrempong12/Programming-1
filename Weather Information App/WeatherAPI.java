import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherAPI {
    private static final String API_KEY = "your_api_key";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast";

    public static JsonObject getWeatherData(String location, String units) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String url = BASE_URL + "?q=" + location + "&units=" + units + "&appid=" + API_KEY;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return JsonParser.parseString(response.body()).getAsJsonObject();
            } else {
                throw new IOException("Invalid API response: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new IOException("Failed to fetch weather data: " + e.getMessage());
        }
    }

    public static JsonArray getForecastData(String location, String units) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String url = FORECAST_URL + "?q=" + location + "&units=" + units + "&appid=" + API_KEY;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
                return jsonObject.getAsJsonArray("list");
            } else {
                throw new IOException("Invalid API response: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new IOException("Failed to fetch forecast data: " + e.getMessage());
        }
    }
}