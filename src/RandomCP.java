package src;
public class RandomCP extends Player{
    
    @Override
    public String chooseOption(){
        //return a number randomly generated between 1 and 3 inclusive
        return convertChoice((int)(Math.random() * 3) + 1);
    }

    public void updateRoundHistory(int roundCount, string playerChoice, string result)
        // this will update the users roundHistory
    }
