package Entities;

public class Answer {
    private String answerId;
    private User user;
    private Question question;
    private String content;
    private int upvotes;

    public Answer(String answerId, User user, Question question, String content, int upvotes) {
        this.answerId = answerId;
        this.user = user;
        this.question = question;
        this.content = content;
        this.upvotes = upvotes;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId='" + answerId + '\'' +
                ", user=" + user +
                ", question=" + question +
                ", content='" + content + '\'' +
                ", upvotes=" + upvotes +
                '}';
    }
}
