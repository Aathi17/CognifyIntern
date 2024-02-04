package intern;
import java.security.SecureRandom;
import java.util.Scanner;
public class RandomPassGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
    
        System.out.print("Include numbers? (Y/N): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include lowercase letters? (Y/N): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include uppercase letters? (Y/N): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include special characters? (Y/N): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("Y");

        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);
        System.out.println("Generated Password: " + password);
        scanner.close();
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialChars) {
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        StringBuilder validChars = new StringBuilder();

        if (includeNumbers) {
            validChars.append(numbers);
        }
        if (includeLowercase) {
            validChars.append(lowercaseLetters);
        }
        if (includeUppercase) {
            validChars.append(uppercaseLetters);
        }
        if (includeSpecialChars) {
            validChars.append(specialChars);
        }

        if (validChars.length() == 0) {
            System.out.println("Error: You must include at least one type of character in the password.");
            System.exit(1);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
