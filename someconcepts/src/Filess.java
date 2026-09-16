import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Filess {
    public static void main (String[] args) {


        try {
            File file = new File ("learningjava.txt");
            FileWriter writer = new FileWriter("learningjava.txt");
            writer.write("Hello I am learning java file handling.");
            writer.close();

            Scanner scanner = new Scanner("learningjava.txt");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

}