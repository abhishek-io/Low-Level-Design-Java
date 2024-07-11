import Entities.Answer;
import Entities.Question;
import Entities.Topic;
import Entities.User;
import Service.QuestionAnswerPlatform;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        QuestionAnswerPlatform qa = new QuestionAnswerPlatform();
        qa.showFeed();
        User user = new User("Abhishek","Programmer");
        qa.userSignup(user);
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic("java"));
        Question q = new Question("a",user,"what is java?",topics);
        qa.askQuestion(q,new String[]{});
        Answer ans = new Answer("i",user,q,"Java is java you dumb",1);
//        qa.asnwerQuestion("a",ans);
//        qa.showFeed();
        qa.logout();

    }
}