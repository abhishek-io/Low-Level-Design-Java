package Entities;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private String profession;
    private Set<String> subscribedTopics;

    public User(String name, String profession) {
        this.name = name;
        this.profession = profession;
        this.subscribedTopics = new HashSet<>();
    }

    public void SubscribedTopics(String topic){
        subscribedTopics.add(topic);
    }

    public String getName() {
        return name;
    }

    public Set<String> getSubscribedTopics() {
        return subscribedTopics;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", subscribedTopics=" + subscribedTopics +
                '}';
    }
}
