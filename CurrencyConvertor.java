package intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConvertor {
    private static final String API_KEY = "4c55c516d971098bc6442b83";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the amount in the base currency: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Fetch and display the exchange rate
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        System.out.println("Exchange Rate (1 " + baseCurrency + " to " + targetCurrency + "): " + exchangeRate);

        // Perform currency conversion
        double convertedAmount = amount * exchangeRate;

        // Display the converted amount
        System.out.println("Converted Amount: " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            String apiUrl = "https://open.er-api.com/v6/latest/" + baseCurrency + "?apikey=" + API_KEY;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            // Parse JSON response to get exchange rate
            String jsonResponse = response.toString();
            int start = jsonResponse.indexOf("\"" + targetCurrency + "\":") + targetCurrency.length() + 4;
            int end = jsonResponse.indexOf(",", start);

            return Double.parseDouble(jsonResponse.substring(start, end));

        } catch (IOException e) {
            e.printStackTrace();
            return -1; // Indicates an error
        }
    }
}
