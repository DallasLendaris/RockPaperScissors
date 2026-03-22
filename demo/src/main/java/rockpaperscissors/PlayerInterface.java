package rockpaperscissors;
public interface PlayerInterface {
    String chooseOption();
    void updateRoundHistory(String playerChoice, String result);
    int getRC();
    Round getRH(int round);
}
