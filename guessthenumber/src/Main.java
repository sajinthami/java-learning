//import java.util.Random;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Random random = new Random();
//        Scanner scanner = new Scanner(System.in);
//
//        int guess;
//        int attempts = 0;
//        int randomNumber = random.nextInt(1, 101);
//
//
//        System.out.println("Number Guessing Game");
//        System.out.println("Enter the number between 1 and 100: ");
//        do{
//            System.out.print("Enter a guess: ");
//            guess = scanner.nextInt();
//            attempts++;
//
//            if (guess > randomNumber){
//                System.out.println("Too high");
//            } else if (guess < randomNumber){
//                System.out.println("Too Low");
//            } else {
//                System.out.println("The correct number was " + randomNumber);
//                System.out.println("Total Number of guess: " + attempts);
//            }
//
//
//        }while(guess != randomNumber);
//
//        scanner.close();
//
//    }
//}




import java.util.Scanner;
import java.util.Random;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int guess;
        int attempts = 0;
        int randomNumber = random.nextInt(1, 51);

        System.out.println("Number Guessing Game");
        System.out.println("Guess the number between 1 and 50:");
        do {
            System.out.print("Enter a guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber){
                System.out.println("Too Low");
            }else if(guess > randomNumber){
                System.out.println("Too High");
            } else{
                System.out.println("The correct number was " + randomNumber);
                System.out.println("The total number of attempt: " + attempts);
            }

        } while(guess != randomNumber);

        scanner.close();
    }
}