package rockpaperscissors;

public class RandomCP extends ComputerPlayer{
    
    @Override
    public String chooseOption(){
        //return a number randomly generated between 1 and 3 inclusive
        return convertChoice((int)(Math.random() * 3) + 1);
    }
}
