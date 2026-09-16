
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static final String FILE_NAME = "student.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== STUDENT RECORD MANAGER =====");
            System.out.println("1. Add student");
            System.out.println("2. Show students");
            System.out.println("Check File");
            System.out.println("File Information");
            System.out.println("Delete File");
            System.out.println("Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> viewStudent();
                case 3 -> checkFile();
                case 4 -> fileInformation();
                case 5 -> deleteFile();
                case 6 -> {
                    System.out.println("Program ended.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // Adding Student
    public static void addStudent(Scanner scanner) {

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age:");
        int age = scanner.nextInt();

        System.out.print("Enter student marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        try {

            FileWriter writer = new FileWriter(FILE_NAME, true);

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Marks: " + marks + "\n");
            writer.write("------------------------\n");

            writer.close();

            System.out.println("Student added successfully.");
        } catch (IOException e) {
            System.out.println("An error occured while writing to the file.");
        }
    }

    // View Student

    public static void viewStudent() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No student found.");
            return;
        }

        try {
            Scanner reader = new Scanner(file);

            System.out.println("\n===== student list ====");

            while (reader.hasNextLine()) {

                String line = reader.nextLine();
                System.out.println(line);

            }
            reader.close();

        } catch (IOException e) {
            System.out.println("An error occured while writing to the file.");
        }
    }

    // Check File
    public static void checkFile() {
        File file = new File(FILE_NAME);

        if(file.exists()) {
            System.out.println("Student.txt exists.");
        } else{
            System.out.println("Student.txt does not exist.");
        }
    }

    // File Information
    public static void fileInformation() {

        File file = new File(FILE_NAME);

        if(!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }
    }

    // Delete File

    public static void deleteFile() {
        File file = new File(FILE_NAME);

        if(!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        if(file.delete()){
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Could not delete file.");
        }
    }
}