

    import java.util.ArrayList;
import java.util.List;

    /**
     * Owns the collection of games and every operation performed on it.
     * Main never touches the ArrayList directly -- it only calls methods here.
     */

    public class Gamelibrary {
        private ArrayList<Game> games;

        public GameLibrary() {
            this.games = new ArrayList<>();
        }

        // --- Add ---
        public void addGame(Game game) {
            games.add(game);
        }

        // --- View ---
        public List<Game> getAllGames() {
            return games; // caller can read, but this is still "view", not "edit"
        }

        public boolean isEmpty() {
            return games.isEmpty();
        }

        // --- Search ---
        // Returns every game whose title contains the search text (case-insensitive).
        // A List, not a single Game, because titles aren't guaranteed unique.
        public List<Game> searchByTitle(String keyword) {
            List<Game> results = new ArrayList<>();
            String lowerKeyword = keyword.toLowerCase();

            for (Game g : games) {
                if (g.getTitle().toLowerCase().contains(lowerKeyword)) {
                    results.add(g);
                }
            }
            return results;
        }

        // --- Rate ---
        // Returns true if a matching game was found and rated, false otherwise.
        public boolean rateGame(String title, double rating) {
            for (Game g : games) {
                if (g.getTitle().equalsIgnoreCase(title)) {
                    g.setRating(rating);
                    return true;
                }
            }
            return false;
        }

        // --- Statistics ---
        public int totalGames() {
            return games.size();
        }

        public double averageRating() {
            double sum = 0.0;
            int ratedCount = 0;

            for (Game g : games) {
                if (g.isRated()) {
                    sum += g.getRating();
                    ratedCount++;
                }
            }
            return ratedCount == 0 ? 0.0 : sum / ratedCount;
        }

        public int totalHoursPlayed() {
            int total = 0;
            for (Game g : games) {
                total += g.getHoursPlayed();
            }
            return total;
        }

        public int completedCount() {
            int count = 0;
            for (Game g : games) {
                if (g.isCompleted()) {
                    count++;
                }
            }
            return count;
        }

        public Game highestRatedGame() {
            Game best = null;
            for (Game g : games) {
                if (g.isRated() && (best == null || g.getRating() > best.getRating())) {
                    best = g;
                }
            }
            return best; // null if nothing is rated yet -- caller must check
        }

        public String mostPlayedGenre() {
            // Simple frequency count using two parallel lists instead of a Map,
            // since Maps haven't come up yet in your learning path.
            List<String> genres = new ArrayList<>();
            List<Integer> counts = new ArrayList<>();

            for (Game g : games) {
                String genre = g.getGenre();
                int index = genres.indexOf(genre);
                if (index == -1) {
                    genres.add(genre);
                    counts.add(1);
                } else {
                    counts.set(index, counts.get(index) + 1);
                }
            }

            String topGenre = null;
            int topCount = 0;
            for (int i = 0; i < genres.size(); i++) {
                if (counts.get(i) > topCount) {
                    topCount = counts.get(i);
                    topGenre = genres.get(i);
                }
            }
            return topGenre; // null if library is empty
        }
    }
