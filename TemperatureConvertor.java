package intern;
import java.util.Scanner;
public class TemperatureConvertor {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Temperature Converter");
	        System.out.print("Enter temperature value: ");
	        double temperature = scanner.nextDouble();
	        System.out.print("Enter unit of measurement (C for Celsius, F for Fahrenheit): ");
	        char unit = scanner.next().charAt(0);
	        if (unit == 'C' || unit == 'c') {
	            double fahrenheit = celsiusToFahrenheit(temperature);
	            System.out.println("Converted temperature in Fahrenheit: " + fahrenheit + " °F");
	        } else if (unit == 'F' || unit == 'f') {
	            double celsius = fahrenheitToCelsius(temperature);
	            System.out.println("Converted temperature in Celsius: " + celsius + " °C");
	        } else {
	            System.out.println("Invalid unit of measurement. Please enter 'C' or 'F'.");
	        }
	        scanner.close();
	    }
	    private static double celsiusToFahrenheit(double celsius) {
	        return (celsius * 9 / 5) + 32;
	    }
	    private static double fahrenheitToCelsius(double fahrenheit) {
	        return (fahrenheit - 32) * 5 / 9;
	    }
	}
