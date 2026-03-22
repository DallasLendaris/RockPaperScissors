package rockpaperscissors;

public class Rules {
    // Return values:
    // 0 = Player 1 wins
    // 1 = Player 2 wins
    // 2 = Tie
    
    public int determineWinner(String player1Choice, String player2Choice) {
        if (player1Choice.equals(player2Choice)) {
            return 2; // Tie
        }
        
        if (beats(player1Choice, player2Choice)) {
            return 0; // Player 1 wins
        } else {
            return 1; // Player 2 wins
        }
    }
    
    private boolean beats(String choice1, String choice2) {
        return ("paper".equals(choice1) && "rock".equals(choice2)) ||
               ("scissors".equals(choice1) && "paper".equals(choice2)) ||
               ("rock".equals(choice1) && "scissors".equals(choice2));
    }
    
    // Optional: Method to display the result
    public void displayResult(String player1Name, String player1Choice, 
                             String player2Name, String player2Choice, 
                             int winner) {
        System.out.print(player1Name + " chose " + player1Choice + ". " +
                        player2Name + " chose " + player2Choice + ". ");
        
        if (winner == 0) {
            System.out.println(player1Name + " wins!");
        } else if (winner == 1) {
            System.out.println(player2Name + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
