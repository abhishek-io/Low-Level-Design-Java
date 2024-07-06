package Services;
import Model.Entities;
import Model.Dice;
import Model.PairPosition;
import java.util.HashMap;

public class PlaySnakeAndLadder {
    HashMap<String,PairPosition> playerHistory;
    HashMap<String,Integer> playerLatestPosition;
    Entities entities;
    Dice dice;

    public PlaySnakeAndLadder(int N){
        playerHistory = new HashMap<>();
        playerLatestPosition = new HashMap<>();
        entities = Entities.getInstance();
        dice = new Dice(N);
    }

    public String PlayGame(){
        initilizePlayersStartValue();
        int i = -1;
        do{
            i++;
            if(i>=entities.getPlayers().size())
                i=0;
            StringBuilder str = new StringBuilder();
            String playerName = entities.getPlayers().get(i);
            str.append(playerName);
            int diceNumber = dice.getNumberOfDice();
            int endPosition = playerLatestPosition.get(playerName)+diceNumber;
            String sl = "";
            if(checkForDiceNumberGreaterThanHundred(endPosition)){
                str.append("roled a ").append(diceNumber);
                str.append("and moved from ").append(playerLatestPosition.get(playerName));
                if(entities.getSnakes().get(endPosition) != null){
                    sl = " after snake dinner ";
                    playerLatestPosition.put(playerName,entities.getSnakes().get(endPosition));
                }
                else{
                    if(entities.getladders().get(endPosition) != null){
                        sl = " after ladder ride ";
                        playerLatestPosition.put(playerName,entities.getladders().get(endPosition));
                    }
                    else{
                        playerLatestPosition.put(playerName,endPosition);
                    }
                }
                str.append(" to ").append(playerLatestPosition.get(playerName));
                str.append(sl);
            }
            System.out.println(str);
        }while(!isPlayerWon(entities.getPlayers().get(i)));

        return entities.getPlayers().get(i);
    }

    public boolean checkForDiceNumberGreaterThanHundred(int endPos){
        return endPos<=100;
    }

    public boolean isPlayerWon(String player){
        return playerLatestPosition.get(player) == 100;
    }

    public void initilizePlayersStartValue(){
        for(int i=0;i<entities.getPlayers().size();i++){
            playerLatestPosition.put(entities.getPlayers().get(i),0);
        }
    }
}
