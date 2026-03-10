package src;
import java.util.HashMap;
public class Player extends Game{
    private int wins;
    private int ties;
    private HashMap<Integer, round> roundHistory = new HashMap<>();
    public Player(){
        wins = 0;
        ties = 0;
    }

    public int getWins(){
        return wins;
    }
    public void setWins(int w){
        wins = w;
    }
    public int getTies(){
        return ties;
    }
    public void setTies(int t){
        ties = t;
    }
    
    public String chooseOption(){
        // Provides the user with the option of rock, paper, or scissors
        // return the users choice
    }

    public void updateRoundHistory(int roundCount, String playerChoice, boolean result){
        // this will update the users roundHistory
        round obj = new round(playerChoice, result);
        roundHistory.put(roundCount, obj);
    }




   
}