package rockpaperscissors;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmartCPTest {
    private SmartCP cp;
    
    @BeforeEach
    public void setUp() {
        cp = new SmartCP();
    }
    
    @Test
    public void testFirstRoundIsRandom() {
        String choice = cp.chooseOption();
        assertTrue(
            choice.equals("rock") || choice.equals("paper") || choice.equals("scissors"),
            "First choice should be a valid option"
        );
    }
    
    @Test
    public void testChoosesRockAfterLoss() {
        // Simulate a loss in round 1
        cp.updateRoundHistory("scissors", "lost");
        
        // Round 2 should choose rock
        String choice = cp.chooseOption();
        assertEquals("rock", choice, "SmartCP should choose rock after a loss");
    }
    
    @Test
    public void testRandomChoiceAfterWin() {
        // Simulate a win
        cp.updateRoundHistory("rock", "win");
        
        String choice = cp.chooseOption();
        assertTrue(
            choice.equals("rock") || choice.equals("paper") || choice.equals("scissors"),
            "After a win, SmartCP should choose randomly"
        );
    }
    
    @Test
    public void testRandomChoiceAfterTie() {
        // Simulate a tie
        cp.updateRoundHistory("paper", "tie");
        
        String choice = cp.chooseOption();
        assertTrue(
            choice.equals("rock") || choice.equals("paper") || choice.equals("scissors"),
            "After a tie, SmartCP should choose randomly"
        );
    }
    
    @Test
    public void testConsecutiveLosses() {
        // Loss in round 1
        cp.updateRoundHistory("scissors", "lost");
        assertEquals("rock", cp.chooseOption(), "Should choose rock after first loss");
        
        // Loss in round 2
        cp.updateRoundHistory("rock", "lost");
        assertEquals("rock", cp.chooseOption(), "Should choose rock after second loss");
    }
    
    @Test
    public void testLossAfterWin() {
        // Win in round 1
        cp.updateRoundHistory("paper", "win");
        
        // Loss in round 2
        cp.updateRoundHistory("scissors", "lost");
        
        String choice = cp.chooseOption();
        assertEquals("rock", choice, "Should choose rock after most recent loss");
    }
}
