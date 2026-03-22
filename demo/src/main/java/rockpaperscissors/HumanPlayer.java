package rockpaperscissors;
import java.util.HashMap;
import java.util.Scanner;

public class HumanPlayer implements PlayerInterface {
    private int roundCount;
    private HashMap<Integer, Round> roundHistory = new HashMap<>();
    private Scanner scanner;
    
    public HumanPlayer(Scanner scanner) {
        this.scanner = scanner;
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
    
    @Override
    public String chooseOption() {
        String choice;
        
        do {
            System.out.print("Round " + roundCount + ", Enter your choice (Rock, Paper, or Scissors): ");
            choice = scanner.nextLine().trim().toLowerCase();
            
            if (!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissors")) {
                System.out.println("Invalid input. Please enter Rock, Paper, or Scissors.");
            }
        } while (!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissors"));
        
        return choice;
    }
    
    @Override
    public void updateRoundHistory(String playerChoice, String result) {
        Round obj = new Round(playerChoice, result);
        roundHistory.put(roundCount, obj);
        roundCount++;
    }
}
