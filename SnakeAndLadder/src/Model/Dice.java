package Model;
import java.util.Random;
public class Dice {
    private int noOfDice;
    private static int MIN = 1;
    Random random;
    public Dice(int noOfDice){
        this.noOfDice = noOfDice;
        random = new Random();
    }

    public int getNumberOfDice(){
        return random.nextInt((this.noOfDice - MIN)+1)+1;
    }
}
