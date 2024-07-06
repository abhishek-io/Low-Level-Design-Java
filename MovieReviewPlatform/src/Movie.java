import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String movieId;
    private String title;
    private int releaseYear;
    private String genre;
    private List<Review> reviews;

    public Movie(String movieId, String title, int releaseYear, String genre) {
        this.movieId = movieId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        reviews = new ArrayList<>();
    }
    public void addReview(Review review) {
        reviews.add(review);
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public String getMovieId() {
        return movieId;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public String getGenre() {
        return genre;
    }
    public int getTotalReviewScore(){
        return reviews.stream().mapToInt(Review::getEffectiveScore).sum();
    }

    public String getTitle() {
        return title;
    }
}
