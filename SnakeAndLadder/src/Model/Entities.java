package Model;
import java.util.HashMap;
public class Entities {
    static HashMap<Integer,Integer> snakes;
    static HashMap<Integer,Integer> ladders;
    static HashMap<Integer,String> players;
    static Entities instance = null;

    public Entities(){
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        players = new HashMap<>();
    }

    public void setSnakes(int head,int tail){
        snakes.put(head,tail);
    }

    public HashMap<Integer,Integer> getSnakes(){
        return snakes;
    }

    public void setLadders(int bottom, int top){
        ladders.put(bottom,top);
    }

    public HashMap<Integer,Integer> getladders(){
        return ladders;
    }

    public void setPlayers(int no, String name){
        players.put(no,name);
    }

    public HashMap<Integer,String> getPlayers(){
        return players;
    }

    public static Entities getInstance(){
        if(instance == null){
            instance = new Entities();
        }
        return instance;
    }
}

