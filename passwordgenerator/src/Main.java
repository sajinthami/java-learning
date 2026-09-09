import java.security.SecureRandom;
import java.util.Scanner;

// Handles the actual password creation logic.
class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}?";

    // All allowed characters combined into one pool to pick from.
    private static final String ALL_CHARS = LOWERCASE + UPPERCASE + DIGITS + SYMBOLS;

    private SecureRandom random;

    public PasswordGenerator() {
        random = new SecureRandom();
    }

    public String generate(int length) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALL_CHARS.length());
            char randomChar = ALL_CHARS.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}

// Entry point: gets user input and prints the result.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordGenerator generator = new PasswordGenerator();

        System.out.print("Enter desired password length: ");
        int length = Integer.parseInt(scanner.nextLine());

        if (length <= 0) {
            System.out.println("Length must be a positive number.");
        } else {
            String password = generator.generate(length);
            System.out.println("Generated password: " + password);
        }

        scanner.close();
    }
}