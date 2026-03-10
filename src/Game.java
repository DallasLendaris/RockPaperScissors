package src;
import java.util.Scanner;
public class Game{ 
    private static int computeWinner(String userChoice, String CPChoice){
        // Rock = 1, Paper = 2, Scissors = 3
        // return 0 = Human Wins
        // return 1 = Computer Wins
        // return 2 = Tie
        if(("paper".equals(userChoice) && "rock".equals(CPChoice)) ||
            ("scissors".equals(userChoice) && "paper".equals(CPChoice)) ||
            ("rock".equals(userChoice) && "scissors".equals(CPChoice))){
            System.out.println("You chose " + userChoice + ". The Computer chose " + 
            CPChoice + ". You Win!");
            return 0;
        }
        else if(("paper".equals(CPChoice) && "rock".equals(userChoice)) ||
            ("scissors".equals(CPChoice) && "paper".equals(userChoice)) ||
            ("rock".equals(CPChoice) && "scissors".equals(userChoice))){  
            System.out.println("You chose " + userChoice + ". The Computer chose " + 
            CPChoice + ". The Computer Wins!");
            return 1;
        }
        else{
            System.out.println("You chose " + userChoice + ", The Compter chose " + 
                CPChoice + ". You two tie."
            );
            return 2;
        }
    }
    public static void main(String[] args) {
        int roundNumber = 1;
        Player user = new Player();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your opponent:");
        System.out.println("1. Easy (RandomCP)");
        System.out.println("2. Medium (SmartCP)");
        System.out.println("3. Hard (GeniusCP)");

        int choice;
        Player computer = null;

        do {
            System.out.print("Enter your choice (1, 2, or 3): ");
            while (!scanner.hasNextInt()) { // Validate input
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                scanner.next(); // Clear invalid input
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
        } while (computer == null); // Repeat until a valid choice is made
        // Continue with the game logic
        System.out.println("Game starting...");
        while(roundNumber <= 20){
            String userChoice = user.chooseOption();
            String CPChoice = computer.chooseOption();
            int roundResult = computeWinner(userChoice, CPChoice);
            if(roundResult == 0){
                user.updateRoundHistory(userChoice, "win");
                computer.updateRoundHistory(CPChoice, "lost");
            }
            else if(roundResult == 1){
                user.updateRoundHistory(userChoice, "lost");
                computer.updateRoundHistory(CPChoice, "win");
            }
            else if(roundResult == 2){
                user.updateRoundHistory(userChoice, "tie");
                computer.updateRoundHistory(CPChoice, "tie");
            }
            roundNumber++;
        }
    }
    // 1. Create an object of the player
    // 2. Have the user choose which cp to use and create an object based off the choice
    // 3. String userChoice = userObject.chooseOption()
    // 4. String CPChoice = CPObject.chooseOption()
    // 5. Boolean roundResult computeWinner(userChoice, CPChoice)
    // 6. userObject.updateRoundHistory(userChoice, roundResult)
    // 7. CPObject.updateRoundHistory(CPChoice, roundResult)
    // Loop 3 - 7 from roundCount 0-20

}