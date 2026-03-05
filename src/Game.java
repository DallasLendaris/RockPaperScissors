package src;
public class Game{
    private int roundCount;
    
    public Game(){
        roundCount = 0;
    }

    public void setRC(int rc){
        roundCount = rc;
    }
    public int getRC(){
        return roundCount;
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

    // Incomplete
    private int displayRound(){
        // Using the roundCount display...
        //      "Round __ - Choose (1=Rock, 2=Paper, 3=Scissors): 
    }

    private int computeWinner(int userChoice, int CPChoice){
        // Rock = 1, Paper = 2, Scissors = 3
        // return 0 = Human Wins
        // return 1 = Computer Wins

        if((userChoice == 2 && CPChoice == 1) ||
           (userChoice == 3 && CPChoice == 2) ||
           (userChoice == 1 && CPChoice == 3)){
            System.out.println("You chose " + convertChoice(userChoice) + ". The Computer chose " + 
            convertChoice(CPChoice) + ". You Win!");
            return 0;
        }
        
        System.out.println("You chose " + convertChoice(userChoice) + ". The Computer chose " + 
        convertChoice(CPChoice) + ". The Computer Wins!");
        return 1;
    }


}