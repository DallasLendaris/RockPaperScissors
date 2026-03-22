package rockpaperscissors;
import java.util.Scanner;

public class Game {
    private PlayerInterface human;
    private PlayerInterface computer;
    private Rules rules;
    private Scanner scanner;
    private int roundNumber;
    
    public Game() {
        this.scanner = new Scanner(System.in);
        this.rules = new Rules();
        this.roundNumber = 1;
    }
    
    // Select opponent difficulty
    private void selectOpponent() {
        System.out.println("Choose your opponent:");
        System.out.println("1. Easy (RandomCP)");
        System.out.println("2. Medium (SmartCP)");
        System.out.println("3. Hard (GeniusCP)");
        
        int choice;
        
        do {
            System.out.print("Enter your choice (1, 2, or 3): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                scanner.next();
            }
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    computer = new RandomCP();
                    System.out.println("You chose Easy.");
                    break;
                case 2:
                    computer = new SmartCP();
                    System.out.println("You chose Medium.");
                    break;
                case 3:
                    computer = new GeniusCP();
                    System.out.println("You chose Hard.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } while (computer == null);
    }
    
    // Play a single round
    private void playRound() {
        String userChoice = human.chooseOption();
        String cpuChoice = computer.chooseOption();
        
        int result = rules.determineWinner(userChoice, cpuChoice);
        rules.displayResult("You", userChoice, "Computer", cpuChoice, result);
        
        // Update histories based on result
        if (result == 0) {
            human.updateRoundHistory(userChoice, "win");
            computer.updateRoundHistory(cpuChoice, "lost");
        } else if (result == 1) {
            human.updateRoundHistory(userChoice, "lost");
            computer.updateRoundHistory(cpuChoice, "win");
        } else {
            human.updateRoundHistory(userChoice, "tie");
            computer.updateRoundHistory(cpuChoice, "tie");
        }
    }
    
    // Display final results
    private void displayFinalResults() {
        int humanWins = 0;
        int computerWins = 0;
        int ties = 0;
        
        for (int i = 1; i < roundNumber; i++) {
            Round round = human.getRH(i);
            if (round != null) {
                String result = round.getRes();
                if ("win".equals(result)) {
                    humanWins++;
                } else if ("lost".equals(result)) {
                    computerWins++;
                } else {
                    ties++;
                }
            }
        }
        
        System.out.println("\n=== GAME OVER ===");
        System.out.println("Final Score:");
        System.out.println("You: " + humanWins + " wins");
        System.out.println("Computer: " + computerWins + " wins");
        System.out.println("Ties: " + ties);
        
        if (humanWins > computerWins) {
            System.out.println("Congratulations! You won the game!");
        } else if (computerWins > humanWins) {
            System.out.println("Computer wins the game!");
        } else {
            System.out.println("The game is a tie!");
        }
    }
    
    // Main game loop
    public void start() {
        boolean playAgain = true;
        while (playAgain) {
            human = new HumanPlayer(scanner);
            selectOpponent();
            
            System.out.println("Game starting...");
            roundNumber = 1;
            
            while (roundNumber <= 20) {
                playRound();
                roundNumber++;
            }
            
            displayFinalResults();
            
            System.out.print("Play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }
        
        scanner.close();
    }
    
    // Simple main method that just creates and starts the game
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}