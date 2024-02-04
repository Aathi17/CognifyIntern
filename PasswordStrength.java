package intern;
import java.util.Scanner;

public class PassStrength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[a-zA-Z0-9]*");

        System.out.println("Password Strength:");

        if (length >= 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            System.out.println("Strong");
        } else if (length >= 6 && (hasUppercase || hasLowercase) && (hasDigit || hasSpecialChar)) {
            System.out.println("Moderate");
        } else {
            System.out.println("Weak");
        }

        scanner.close();
    }
}
