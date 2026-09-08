import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        String[] choices = {"rock", "paper", "scissor"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rock/paper/scissor: ");
        String user = scanner.nextLine().toLowerCase();
        String computer = choices[random.nextInt(3)];

        System.out.println("Computer: " + computer);

        if(user.equals(computer)){
            System.out.println("It is a draw.");
        } else if (
                user.equals("rock") && computer.equals("scissor") ||
                        user.equals("paper") && computer.equals("rock") ||
                        user.equals("scissor") && computer.equals("paper")) {
            System.out.println("You won");

        }else {
            System.out.println("Computer Won!! Try again.");
        }
        scanner.close();
    }
}