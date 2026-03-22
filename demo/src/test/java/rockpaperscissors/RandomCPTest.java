package rockpaperscissors;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomCPTest {
    
    @Test
    public void testChooseOptionReturnsValidChoice() {
        RandomCP cp = new RandomCP();
        String choice = cp.chooseOption();
        
        assertTrue(
            choice.equals("rock") || choice.equals("paper") || choice.equals("scissors"),
            "RandomCP should return rock, paper, or scissors"
        );
    }
    
    @RepeatedTest(50)
    public void testRandomChoicesAreValid() {
        RandomCP cp = new RandomCP();
        String choice = cp.chooseOption();
        
        assertTrue(
            choice.equals("rock") || choice.equals("paper") || choice.equals("scissors"),
            "Every random choice should be valid"
        );
    }
    
    @Test
    public void testInitialRoundCount() {
        RandomCP cp = new RandomCP();
        assertEquals(1, cp.getRC(), "RandomCP should start at round 1");
    }
    
    @Test
    public void testUpdateRoundHistory() {
        RandomCP cp = new RandomCP();
        
        assertEquals(1, cp.getRC(), "Should start at round 1");
        
        cp.updateRoundHistory("rock", "win");
        
        assertEquals(2, cp.getRC(), "Round count should increment after update");
        assertNotNull(cp.getRH(1), "Round 1 should exist in history");
        assertEquals("rock", cp.getRH(1).getPC(), "Should store correct choice");
        assertEquals("win", cp.getRH(1).getRes(), "Should store correct result");
    }
    
    @Test
    public void testMultipleRoundHistory() {
        RandomCP cp = new RandomCP();
        
        cp.updateRoundHistory("rock", "win");
        cp.updateRoundHistory("paper", "lost");
        cp.updateRoundHistory("scissors", "tie");
        
        assertEquals(4, cp.getRC(), "Should be at round 4 after 3 updates");
        assertEquals("rock", cp.getRH(1).getPC());
        assertEquals("paper", cp.getRH(2).getPC());
        assertEquals("scissors", cp.getRH(3).getPC());
    }
}