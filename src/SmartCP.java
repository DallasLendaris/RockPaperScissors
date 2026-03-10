package src;
public class SmartCP extends RandomCP{
    @Override
    public String chooseOption(){
        // If the last round result was a loss ...
        // else randomly choose
        if(getRC() == 1){
            return convertChoice((int)(Math.random() * 3) + 1);
        }
        Round lastRound = getRH(getRC()-1);
        if(lastRound.getRes().equals("lost")){
            return "Rock";
        }
        else{
            return convertChoice((int)(Math.random() * 3) + 1);
        }
    }
}
