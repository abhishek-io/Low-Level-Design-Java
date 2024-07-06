import java.util.Scanner;
import Model.Entities;
import Services.PlaySnakeAndLadder;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Entities entities = Entities.getInstance();
        System.out.println("enter no of snakes");
        int noOfSnakes = scan.nextInt();
        while(noOfSnakes>0){
            int startPosition = scan.nextInt();
            int endPosition = scan.nextInt();
            entities.setSnakes(startPosition, endPosition);
            noOfSnakes--;
        }
        System.out.println("enter no of ladders");
        int noOfLadders = scan.nextInt();
        while(noOfLadders>0){
            int startPosition = scan.nextInt();
            int endPosition = scan.nextInt();
            entities.setLadders(startPosition, endPosition);
            noOfLadders--;
        }
        System.out.println("enter no of players");
        int noOfPlayers = scan.nextInt();
        int i=0;
        while(noOfPlayers>0){
            String player = scan.next();
            entities.setPlayers(i++, player);
            noOfPlayers--;
        }
        PlaySnakeAndLadder playSnakeAndLadder = new PlaySnakeAndLadder(6);
        System.out.println(playSnakeAndLadder.PlayGame()+" wins the game");
    }
}