import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class WeatherApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField locationInput = new TextField();
        locationInput.setPromptText("Enter city name");

        Button getWeatherButton = new Button("Get Weather");

        Label weatherInfo = new Label();
        HBox weatherIcons = new HBox();
        weatherIcons.setAlignment(Pos.CENTER);

        VBox forecastBox = new VBox();
        forecastBox.setAlignment(Pos.CENTER);

        ToggleGroup tempUnitToggleGroup = new ToggleGroup();
        RadioButton celsiusButton = new RadioButton("Celsius");
        RadioButton fahrenheitButton = new RadioButton("Fahrenheit");
        celsiusButton.setToggleGroup(tempUnitToggleGroup);
        fahrenheitButton.setToggleGroup(tempUnitToggleGroup);
        celsiusButton.setSelected(true); // Default to Celsius
        HBox tempUnitBox = new HBox(celsiusButton, fahrenheitButton);
        tempUnitBox.setAlignment(Pos.CENTER);

        ToggleGroup windUnitToggleGroup = new ToggleGroup();
        RadioButton msButton = new RadioButton("m/s");
        RadioButton mphButton = new RadioButton("mph");
        msButton.setToggleGroup(windUnitToggleGroup);
        mphButton.setToggleGroup(windUnitToggleGroup);
        msButton.setSelected(true); // Default to m/s
        HBox windUnitBox = new HBox(msButton, mphButton);
        windUnitBox.setAlignment(Pos.CENTER);

        ListView<String> historyListView = new ListView<>();
        VBox vbox = new VBox(locationInput, getWeatherButton, weatherInfo, weatherIcons, forecastBox, tempUnitBox, windUnitBox, historyListView);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(LocalTime.of(6, 0)) && currentTime.isBefore(LocalTime.of(18, 0))) {
            vbox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null))); // Daytime background
        } else {
            vbox.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null))); // Nighttime background
        }

        Map<String, String> weatherBackgrounds = new HashMap<>();
        weatherBackgrounds.put("clear", "clear_sky_background.jpg");
        weatherBackgrounds.put("clouds", "cloudy_background.jpg");
        // Add more mappings for other weather conditions as needed

        getWeatherButton.setOnAction(event -> {
            String location = locationInput.getText().trim();
            if (location.isEmpty()) {
                weatherInfo.setText("Please enter a location.");
                return;
            }

            String units = celsiusButton.isSelected() ? "metric" : "imperial";
            try {
                JsonObject weatherData = WeatherAPI.getWeatherData(location, units);
                JsonArray forecastData = WeatherAPI.getForecastData(location, units);
                weatherInfo.setText(parseWeatherData(weatherData));
                updateWeatherIcons(weatherData, weatherIcons);
                updateForecast(forecastData, forecastBox);

                SearchHistoryManager.addToHistory(location);
                updateHistoryList(historyListView);

                String weatherCondition = weatherData.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString().toLowerCase();
                String backgroundImageUrl = weatherBackgrounds.getOrDefault(weatherCondition, "default_background.jpg");
                vbox.setBackground(new Background(new BackgroundImage(new Image(backgroundImageUrl), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            } catch (IOException e) {
                weatherInfo.setText("Failed to fetch weather data. Please try again later.");
            } catch (InterruptedException e) {
                weatherInfo.setText("Request interrupted. Please try again later.");
            }
        });

        Scene scene = new Scene(vbox, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Weather Information App");
        primaryStage.show();
    }

    private String parseWeatherData(JsonObject weatherData) {
        JsonObject main = weatherData.getAsJsonObject("main");
        JsonObject wind = weatherData.getAsJsonObject("wind");
        String temperature = main.get("temp").getAsString();
        String humidity = main.get("humidity").getAsString();
        String windSpeed = wind.get("speed").getAsString();
        return String.format("Temperature: %s\nHumidity: %s\nWind Speed: %s", temperature, humidity, windSpeed);
    }

    private void updateWeatherIcons(JsonObject weatherData, HBox weatherIcons) {
        weatherIcons.getChildren().clear();
        JsonArray weatherArray = weatherData.getAsJsonArray("weather");
        for (int i = 0; i < weatherArray.size(); i++) {
            JsonObject weather = weatherArray.get(i).getAsJsonObject();
            String iconCode = weather.get("icon").getAsString();
            ImageView iconView = new ImageView(new Image("http://openweathermap.org/img/wn/" + iconCode + "@2x.png"));
            weatherIcons.getChildren().add(iconView);
        }
    }

    private void updateForecast(JsonArray forecastData, VBox forecastBox) {
        forecastBox.getChildren().clear();
        for (int i = 0; i < Math.min(forecastData.size(), 5); i++) { // Display next 5 forecasts
            JsonObject forecast = forecastData.get(i).getAsJsonObject();
            String dateTime = forecast.get("dt_txt").getAsString();
            JsonObject main = forecast.getAsJsonObject("main");
            String temperature = main.get("temp").getAsString();
            String humidity = main.get("humidity").getAsString();
            JsonArray weatherArray = forecast.getAsJsonArray("weather");
            String description = weatherArray.get(0).getAsJsonObject().get("description").getAsString();
            String iconCode = weatherArray.get(0).getAsJsonObject().get("icon").getAsString();

            HBox forecastItem