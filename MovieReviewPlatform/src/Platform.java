import java.util.*;
import java.util.stream.Collectors;

public class Platform {
    private Map<String,User> users;
    private Map<String,Movie> movies;

    public Platform(){
        users = new HashMap<>();
        movies = new HashMap<>();
    }
    public void addUser(String userId,String name){
        users.put(userId, new User(userId,name));
    }
    public void addMovie(String movieId, String title, int releaseYear, String genre){
        movies.put(movieId,new Movie(movieId,title,releaseYear,genre));
    }
    public void addReview(String userId,String movieId, int score){
        User user = users.get(userId);
        Movie movie = movies.get(movieId);
        if(movie.getReleaseYear()<= Calendar.getInstance().get(Calendar.YEAR)){
            Review review = new Review(user,movie,score);
            user.addReview(review);
            movie.addReview(review);
        }
        else{
            throw new IllegalArgumentException("Cannot review unreleases movie.");
        }
    }
    public void updateReview(String userId,String movieId,int score){
        User user = users.get(userId);
        user.updateReview(movieId,score);
    }
    public void deleteReview(String userId,String movieId){
        User user = users.get(userId);
        user.deleteReview(movieId);
    }
    public List<Review> getReviewsByUser(String userId){
        return users.get(userId).getReviews();
    }
    public List<Movie> listTopNMoviesByTotalScore(int n,int year,String genre){
       return movies.values().stream()
               .filter(movie->movie.getReleaseYear()==year && movie.getGenre().equalsIgnoreCase(genre))
               .sorted(Comparator.comparingInt(Movie::getTotalReviewScore).reversed())
               .limit(n)
               .collect(Collectors.toList());
    }

}
