import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private UserType userType;
    private List<Review> reviews;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.userType = UserType.VIEWER;
        reviews = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", userType=" + userType +
                ", reviews=" + reviews +
                '}';
    }

    public String getName() {
        return name;
    }

    public void addReview(Review review){
        this.reviews.add(review);
        checkForUpgrade();
    }
    public void updateReview(String movieId,int score){
        for(Review review:reviews){
            if(review.getMovie().getMovieId().equals(movieId)){
                review.setScore(score);
                return;
            }
        }
    }
    public void deleteReview(String movieId){
        reviews.removeIf(review->review.getMovie().getMovieId().equals(movieId));
    }
    public List<Review> getReviews(){
        return reviews;
    }
    public void checkForUpgrade(){
        if(userType == UserType.VIEWER && reviews.size()>3){
            userType = UserType.CRITIC;
        }
    }

    public UserType getUserType() {
        return userType;
    }
}
