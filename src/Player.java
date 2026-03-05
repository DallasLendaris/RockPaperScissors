package src;
public class Player extends Game{
    private int wins;
    private int ties;

    public Player(){
        wins = 0;
        ties = 0;
    }

    public int getWins(){
        return wins;
    }
    public void setWins(int w){
        wins = w;
    }
    public int getTies(){
        return ties;
    }
    public void setTies(int t){
        ties = t;
    }
    
    // Have the user input their option
    public int chooseOption(){

    }
}