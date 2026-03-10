package src;
public class round {
    private String playerChoice;
    private boolean result;

    public round(String pc, boolean res){
        playerChoice = pc;
        result = res;
    }

    public String getPC(){
        return playerChoice;
    }
    public boolean getRes(){
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
