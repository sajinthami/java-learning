import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GameLibrary library = new GameLibrary();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> addGame();
                case 2 -> viewAllGames();
                case 3 -> searchGames();
                case 4 -> rateGame();
                case 5 -> showStatistics();
                case 6 -> running = false;
                default -> System.out.println("Invalid option. Try again.\n");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("===== GAME LIBRARY =====");
        System.out.println("1. Add a game");
        System.out.println("2. View all games");
        System.out.println("3. Search games");
        System.out.println("4. Rate a game");
        System.out.println("5. View statistics");
        System.out.println("6. Exit");
    }

    private static void addGame() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        int hours = readInt("Hours played so far: ");

        System.out.print("Completed? (y/n): ");
        boolean completed = scanner.nextLine().trim().equalsIgnoreCase("y");

        library.addGame(new Game(title, genre, hours, completed));
        System.out.println("\"" + title + "\" added.\n");
    }

    private static void viewAllGames() {
        if (library.isEmpty()) {
            System.out.println("Your library is empty.\n");
            return;
        }

        System.out.println("\n" + "-".repeat(80));
        for (Game g : library.getAllGames()) {
            System.out.println(g);
        }
        System.out.println("-".repeat(80) + "\n");
    }

    private static void searchGames() {
        System.out.print("Search by title: ");
        String keyword = scanner.nextLine();

        List<Game> results = library.searchByTitle(keyword);

        if (results.isEmpty()) {
            System.out.println("No matches found.\n");
            return;
        }

        System.out.println("\n" + "-".repeat(80));
        for (Game g : results) {
            System.out.println(g);
        }
        System.out.println("-".repeat(80) + "\n");
    }

    private static void rateGame() {
        System.out.print("Title to rate: ");
        String title = scanner.nextLine();

        double rating = readDouble("Rating (0-10): ");

        try {
            boolean success = library.rateGame(title, rating);
            if (success) {
                System.out.println("Rated \"" + title + "\" -> " + rating + "/10\n");
            } else {
                System.out.println("No game found with that title.\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    private static void showStatistics() {
        if (library.isEmpty()) {
            System.out.println("No games yet -- nothing to show.\n");
            return;
        }

        System.out.println("\n===== STATISTICS =====");
        System.out.println("Total games: " + library.totalGames());
        System.out.println("Completed: " + library.completedCount());
        System.out.println("Total hours played: " + library.totalHoursPlayed());
        System.out.printf("Average rating: %.2f/10%n", library.averageRating());

        Game best = library.highestRatedGame();
        System.out.println("Highest rated: " + (best == null ? "None rated yet" : best.getTitle()));

        String topGenre = library.mostPlayedGenre();
        System.out.println("Most common genre: " + (topGenre == null ? "N/A" : topGenre));
        System.out.println();
    }

    // --- Small input helpers so the menu methods above stay readable ---
    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a whole number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline
        return value;
    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume leftover newline
        return value;
    }
}