import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApp {

    public void get_status() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a city name: ");
        String city = scanner.nextLine();

        String apiKey = "YOUR_API_KEY";

        try {
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            int startTempIndex = response.indexOf("\"temp\":") + 7;
            int endTempIndex = response.indexOf(",", startTempIndex);
            double temperature = Double.parseDouble(response.substring(startTempIndex, endTempIndex)) - 273.15;

            int startHumidityIndex = response.indexOf("\"humidity\":") + 11;
            int endHumidityIndex = response.indexOf("}", startHumidityIndex);
            int humidity = Integer.parseInt(response.substring(startHumidityIndex, endHumidityIndex));

            System.out.println("Weather in " + city);
            System.out.println("Temperature: " + temperature + " °C");
            System.out.println("Humidity: " + humidity + "%");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }
}
