public class Review {
    private User user;
    private Movie movie;
    private int score;

    public Review(User user, Movie movie, int score) {
        this.user = user;
        this.movie = movie;
        this.score = score;
    }
    public int getEffectiveScore(){
        return user.getUserType() == UserType.CRITIC ? score * 2: score;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Review{" +
                "user=" + user +
                ", movie=" + movie +
                ", score=" + score +
                '}';
    }
}
