package rockpaperscissors;


public class GeniusCP extends SmartCP{
    private int rockTotal;
    private int paperTotal;
    private int scissorsTotal;

    public GeniusCP(){
        rockTotal = 0;
        paperTotal = 0;
        scissorsTotal = 0;
    }
    public String largestOption(){
        if(rockTotal >= paperTotal && rockTotal >= scissorsTotal){return "rock";}
        else if(paperTotal >= rockTotal && paperTotal >= scissorsTotal){return "paper";}
        else{return "scissors";}
    }
    public void updateTotals(){
        String updateOption = "";
        for(int i = 1; i <= getRC(); i++){
            if(getRH(i).getRes().equals("win")){
                updateOption = getRH(i).beats();
            }
            else if(getRH(i).getRes().equals("lost")){
                updateOption = getRH(i).getsBeatBy();
            }
            else{
                updateOption = getRH(i).getPC();
            }
        }
        if(updateOption.equals("rock")){rockTotal++;}
        else if(updateOption.equals("paper")){paperTotal++;}
        else{scissorsTotal++;}
    }
    
    @Override
    public String chooseOption(){
        // (if) every round where round % 5 = 0 repeat the choice from the last round
        // (else if) After 5 round, for every other round choose the option that beats the opponents most used option
        // (else)randomly choose a number from 1-3
        if(getRC() == 1){
            return convertChoice((int)(Math.random() * 3) + 1);
        }
        Round lastRound = getRH(getRC() - 1);
        if(getRC() % 5 == 0){
            return lastRound.getPC();
        }
        else if(getRC() >= 5 && getRC() % 2 == 0){
            return largestOption();
        }
        else{
            return convertChoice((int)(Math.random() * 3) + 1);
        }

    }
}
