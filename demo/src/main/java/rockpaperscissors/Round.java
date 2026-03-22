package rockpaperscissors;
public class Round {
    private String playerChoice;
    private String result;

    public Round(String pc, String res){
        playerChoice = pc;
        result = res;
    }

    public String getPC(){
        return playerChoice;
    }
    public String getRes(){
        return result;
    }

    public String beats(){
        if(playerChoice.equals("rock")){return "scissors";}
        else if(playerChoice.equals("paper")){return "rock";}
        else{return "paper";}
    }

    public String getsBeatBy(){
        if(playerChoice.equals("rock")){return "paper";}
        else if(playerChoice.equals("paper")){return "scissors";}
        else{return "rock";}
    }
}
