/**
 * Represents a single game in the library.
 * Fields are private -> only Game itself can change its own data (encapsulation).
 */
public class Game {

    private String title;
    private String genre;
    private int hoursPlayed;
    private double rating;      // 0.0 means "not rated yet"
    private boolean completed;

    public Game(String title, String genre, int hoursPlayed, boolean completed) {
        this.title = title;
        this.genre = genre;
        this.hoursPlayed = hoursPlayed;
        this.completed = completed;
        this.rating = 0.0;      // unrated by default
    }

    // --- Getters ---
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getHoursPlayed() {
        return hoursPlayed;
    }

    public double getRating() {
        return rating;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isRated() {
        return rating > 0.0;
    }

    // --- Setters (only where it makes sense to change after creation) ---
    public void setRating(double rating) {
        // Guard clause: keep the object itself responsible for staying valid
        if (rating < 0.0 || rating > 10.0) {
            throw new IllegalArgumentException("Rating must be between 0 and 10.");
        }
        this.rating = rating;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void addHours(int hours) {
        this.hoursPlayed += hours;
    }

    @Override
    public String toString() {
        String ratingText = isRated() ? String.format("%.1f/10", rating) : "Not rated";
        String status = completed ? "Completed" : "In progress";
        return String.format("%-25s | %-12s | %4d hrs | %-10s | %s",
                title, genre, hoursPlayed, ratingText, status);
    }
}