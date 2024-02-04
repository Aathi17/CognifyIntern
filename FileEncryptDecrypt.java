package intern;
import java.io.*;
public class FileEncryptionDecryption {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Choose operation (encrypt or decrypt): ");
            String operation = reader.readLine();
            System.out.print("Enter the file name or path: ");
            String fileName = reader.readLine();
            System.out.print("Enter the new file name: ");
            String newFileName = reader.readLine();
            if (operation.equalsIgnoreCase("encrypt")) {
                encryptFile(fileName, newFileName);
                System.out.println("File encrypted successfully.");
            } else if (operation.equalsIgnoreCase("decrypt")) {
                decryptFile(fileName, newFileName);
                System.out.println("File decrypted successfully.");
            } else {
                System.out.println("Invalid operation. Please choose encrypt or decrypt.");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void encryptFile(String inputFileName, String outputFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            int key = 7;

            int data;
            while ((data = reader.read()) != -1) {
                char encryptedChar = (char) (data ^ key);
                writer.write(encryptedChar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decryptFile(String inputFileName, String outputFileName) {
        encryptFile(inputFileName, outputFileName);
    }
}
