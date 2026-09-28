////import java.io.*;
////
////class geeksforgeeks {
////
////    // Computing the value of first fibonacci series
////    // and storing the sum of even indexed numbers
////    static int Fib_Even_Sum(int N)
////    {
////        if (N <= 0)
////            return 0;
////
////        int fib[] = new int[2 * N + 1];
////        fib[0] = 0;
////        fib[1] = 1;
////
////        // Initializing the sum
////        int s = 0;
////
////        // Adding remaining numbers
////        for (int j = 2; j <= 2 * N; j++) {
////            fib[j] = fib[j - 1] + fib[j - 2];
////
////            // Only considering even indexes
////            if (j % 2 == 0)
////                s += fib[j];
////        }
////
////        return s;
////    }
////
////    // The Driver code
////    public static void main(String[] args)
////    {
////        int N = 11;
////
////        // Prints the sum of even-indexed numbers
////        System.out.println(
////                "Even sum of fibonacci series till number " + N
////                        + " is: " + +Fib_Even_Sum(N));
////    }
////}
//
//
//// Program to reverse numbers
//
//public class Main {
//    public static void main(String[] args) {
//
//        int num = 1234, reversed = 0;
//
//        System.out.println("Original Number: " + num);
//
//        // run loop until num becomes 0
//        while(num != 0) {
//
//            // get last digit from num
//            int digit = num % 10;
//            reversed = reversed * 10 + digit;
//
//            // remove the last digit from num
//            num /= 10;
//        }
//
//        System.out.println("Reversed Number: " + reversed);
//    }
//}
//
//
//// Why am I too lazy to code sorry
//
//
//// Goodnight for today also
//
//// Liitle sick today
//
//// Why is not working dude

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