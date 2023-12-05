import java.net.URI;
import java.net.http.*;
import java.util.Scanner;
import org.json.JSONObject;
public class task4_currency_converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = scanner.nextLine();
        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = scanner.nextLine();
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();
        double convertedAmount = amountToConvert * exchangeRate;
        System.out.printf("%s %.2f is equivalent to %s %.2f%n", baseCurrency, amountToConvert, targetCurrency, convertedAmount);
    }
    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        String apiKey = "305bb738f97e00d7f648f60f";
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONObject rates = jsonResponse.getJSONObject("rates");
            return rates.getDouble(targetCurrency);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
