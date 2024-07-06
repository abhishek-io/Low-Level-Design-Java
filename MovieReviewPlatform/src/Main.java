import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Platform platform = new Platform();
        // Add users
        platform.addUser("user1", "Alice");
        platform.addUser("user2", "Bob");

        // Add movies
        platform.addMovie("movie1", "Inception", 2010, "Sci-Fi");
        platform.addMovie("movie2", "The Matrix", 1999, "Action");

        // Add reviews
        platform.addReview("user1", "movie1", 8);
        platform.addReview("user1", "movie2", 9);
        platform.addReview("user1", "movie1", 7);
        platform.addReview("user1", "movie2", 8);

        System.out.println(platform.getReviewsByUser("user1"));

    }
}