package src;
public class Game{
    private int roundCount;
    
    public Game(){
        roundCount = 0;
    }
    public String convertChoice(int choice){
        switch(choice){
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "";
        }
    }
    private boolean computeWinner(String userChoice, String CPChoice){
        // Rock = 1, Paper = 2, Scissors = 3
        // return 0 = Human Wins
        // return 1 = Computer Wins

          if(("Paper".equals(userChoice) && "Rock".equals(CPChoice)) ||
              ("Scissors".equals(userChoice) && "Paper".equals(CPChoice)) ||
              ("Rock".equals(userChoice) && "Scissors".equals(CPChoice))){
            System.out.println("You chose " + userChoice + ". The Computer chose " + 
            CPChoice + ". You Win!");
            return true;
        }
        
        System.out.println("You chose " + userChoice + ". The Computer chose " + 
        CPChoice + ". The Computer Wins!");
        return false;
    }
    public static void main(String[] args) {
        
    }
    // 1. Create an object of the player
    // 2. Have the user choose which cp to use and create an object based off the choice
    // 3. String userChoice = userObject.chooseOption()
    // 4. String CPChoice = CPObject.chooseOption()
    // 5. Boolean roundResult computeWinner(userChoice, CPChoice)
    // 6. userObject.updateRoundHistory(roundCount, userChoice, roundResult)
    // 7. CPObject.updateRoundHistory(roundCount, CPChoice, roundResult)
    // Loop 3 - 7 from roundCount 0-20

}