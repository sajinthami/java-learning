import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create file
        File file = new File("student.txt");

        try {

            if (file.createNewFile()) {
                System.out.println("File created!");
            } else {
                System.out.println("File already exists.");
            }

            // Write to file
            FileWriter writer = new FileWriter(file);

            writer.write("Name: Sajin\n");
            writer.write("Course: BCA\n");
            writer.write("Semester: 2");

            writer.close();

            // Read file
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}