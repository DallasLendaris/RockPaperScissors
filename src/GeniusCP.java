package src;
public class GeniusCP extends SmartCP{
    private int rockTotal;
    private int paperTotal;
    private int scissorsTotal;

    public GeniusCP(){
        rockTotal = 0;
        paperTotal = 0;
        scissorsTotal = 0;
    }

    public String chooseOption(){
        // (if) every round where round % 5 = 0 repeat the choice from the last round
        // (else if) After 5 round, for every other round choose the option that beats the opponents most used option
        // (else)randomly choose a number from 1-3

    }
}
