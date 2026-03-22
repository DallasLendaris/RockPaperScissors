package rockpaperscissors;

import java.util.HashMap;

public abstract class ComputerPlayer implements PlayerInterface {
    private int roundCount;
    private HashMap<Integer, Round> roundHistory = new HashMap<>();
    
    public ComputerPlayer() {
        this.roundCount = 1;
    }
    
    @Override
    public int getRC() {
        return roundCount;
    }
    
    @Override
    public Round getRH(int round) {
        return roundHistory.get(round);
    }
    
    protected String convertChoice(int choice) {
        switch(choice) {
            case 1: return "rock";
            case 2: return "paper";
            case 3: return "scissors";
            default: return "";
        }
    }
    
    @Override
    public void updateRoundHistory(String playerChoice, String result) {
        Round obj = new Round(playerChoice, result);
        roundHistory.put(roundCount, obj);
        roundCount++;
    }
    
    // Each computer player must implement this
    @Override
    public abstract String chooseOption();
}
