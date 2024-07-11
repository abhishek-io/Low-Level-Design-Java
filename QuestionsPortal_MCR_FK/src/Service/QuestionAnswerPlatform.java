package Service;

import Entities.Answer;
import Entities.Question;
import Entities.Topic;
import Entities.User;

import java.text.CollationElementIterator;
import java.util.*;

public class QuestionAnswerPlatform {
    private Map<String, User> users;
    private Map<String, Question> questions;
    private Map<String, Topic> topics;
    private Map<String, List<Answer>> answerByQuestion;

    public QuestionAnswerPlatform(){
        users = new HashMap<>();
        questions = new HashMap<>();
        topics = new HashMap<>();
        answerByQuestion = new HashMap<>();
    }

    public void userSignup(User user){
        users.put(user.getName(),user);
    }

    public void subscribeTopic(Topic topic){
        topics.put(topic.getName(),topic);
    }

    public void askQuestion(Question question,String[] topics){
        List<Topic> existingTopics = question.getTopicsOfQuestion();
        for(String t:topics){
            if(!existingTopics.contains(t)){
                question.addTopic(t);
            }
        }
        questions.put(question.getQuestionId(),question);
    }

    public void asnwerQuestion(String questionId, Answer answer){
        List<Answer> answers = answerByQuestion.getOrDefault(questionId,new ArrayList<>());
        answers.add(answer);
        answerByQuestion.put(questionId,answers);
    }

    public void showFeed(){
        if(!questions.isEmpty()){
            System.out.println("YOUR FEED");
            System.out.println(questions.values().stream().toList());
        }
        else{
            System.out.println("no questions to display");
        }
    }

    public List<Question> showFeedWithFilter(List<String> filterTopics){
        return questions.values().stream()
                .filter(q -> q.getTopicsOfQuestion().containsAll(filterTopics)).toList();
    }

    public void logout(){
        users.clear();
    }
}
