package src;
import java.util.HashMap;
import java.util.Scanner;
public class Player{
    private int roundCount;
    private HashMap<Integer, Round> roundHistory = new HashMap<>();
    public Player(){
        roundCount = 1;
    }
    public int getRC(){
        return roundCount;
    }
    public Round getRH(int round){
        return roundHistory.get(round);
    }
    public String convertChoice(int choice){
        switch(choice){
            case 1:
                return "rock";
            case 2:
                return "paper";
            case 3:
                return "scissors";
            default:
                return "";
        }
    }
    
    public String chooseOption(){
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.print("Round " + roundCount + ", Enter your choice (Rock, Paper, or Scissors): ");
            choice = scanner.nextLine().trim().toLowerCase(); // Convert input to lowercase

            if (!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissors")) {
                System.out.println("Invalid input. Please enter Rock, Paper, or Scissors.");
            }
        } while (!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissors"));

        return choice; // Return the lowercase word
    }

    public void updateRoundHistory(String playerChoice, String result){
        // this will update the users roundHistory
        Round obj = new Round(playerChoice, result);
        roundHistory.put(roundCount, obj);
        roundCount++;
    }
}