package Entities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

public class Question {
    private String questionId;
    private User user;
    private List<Topic> topics;
    private String content;
    private String timestamp;

    public Question(String questionId, User user, String content, List<Topic> topics ) {
        this.questionId = questionId;
        this.user = user;
        this.topics = topics;
        this.content = content;
        this.timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    }

    public String getQuestionId() {
        return questionId;
    }
    public List<Topic> getTopicsOfQuestion(){
        return topics;
    }
    public void addTopic(String topic){
        topics.add(new Topic(topic));
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId='" + questionId + '\'' +
                ", user=" + user +
                ", topics=" + topics +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
