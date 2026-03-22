package rockpaperscissors;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GeniusCPTest {
    private GeniusCP cp;
    
    @BeforeEach
    public void setUp() {
        cp = new GeniusCP();
    }
    
    @Test
    public void testFirstRoundIsRandom() {
        String choice = cp.chooseOption();
        assertTrue(
            choice.equals("rock") || choice.equals("paper") || choice.equals("scissors"),
            "First choice should be valid"
        );
    }
    
    @Test
    public void testRepeatsChoiceOnRound5() {
        // Build up to round 5
        cp.updateRoundHistory("rock", "win");
        cp.updateRoundHistory("paper", "win");
        cp.updateRoundHistory("scissors", "tie");
        cp.updateRoundHistory("paper", "lost");
        
        // Round 5 (getRC() = 5) should repeat round 4's choice
        String choice = cp.chooseOption();
        assertEquals("paper", choice, "Round 5 should repeat previous round's choice");
    }
    
    @Test
    public void testRepeatsChoiceOnRound10() {
        // Build history up to round 10
        for (int i = 1; i <= 9; i++) {
            cp.updateRoundHistory("scissors", "win");
        }
        
        // Round 10 should repeat round 9's choice
        String choice = cp.chooseOption();
        assertEquals("scissors", choice, "Round 10 should repeat previous choice");
    }
    
    @Test
    public void testPatternTrackingOnEvenRounds() {
        // Build history: opponent uses rock twice, paper once
        cp.updateRoundHistory("paper", "win");   // Beat opponent's rock (round 1)
        cp.updateRoundHistory("paper", "win");   // Beat opponent's rock (round 2)
        cp.updateRoundHistory("scissors", "win"); // Beat opponent's paper (round 3)
        cp.updateRoundHistory("rock", "lost");    // Lost to opponent's paper (round 4)
        
        // Round 6 is even and >= 5, should use pattern analysis
        String choice = cp.chooseOption();
        // After updateTotals, rock appears most (2 times)
        // largestOption returns "rock"
        assertEquals("rock", choice, "Should return most common pattern");
    }
    
    @Test
    public void testRoundHistoryTracking() {
        cp.updateRoundHistory("rock", "win");
        
        assertEquals(2, cp.getRC(), "Round count should increment");
        assertEquals("rock", cp.getRH(1).getPC(), "Should store choice");
        assertEquals("win", cp.getRH(1).getRes(), "Should store result");
    }
    
    @Test
    public void testLargestOptionWithTiedCounts() {
        // Create a scenario where rock and paper are tied
        cp.updateRoundHistory("paper", "win");    // Opponent rock
        cp.updateRoundHistory("scissors", "win"); // Opponent paper
        cp.updateRoundHistory("rock", "win");     // Opponent scissors
        cp.updateRoundHistory("paper", "win");    // Opponent rock (tie: 2 rocks, 1 paper, 1 scissors)
        
        // Round 6 - should handle tied counts
        String choice = cp.chooseOption();
        assertTrue(
            choice.equals("rock") || choice.equals("paper"),
            "Should return rock or paper (tied for most common)"
        );
    }
    
    @Test
    public void testOddRoundsBetween5And10() {
        // Build to round 7 (odd, >= 5)
        for (int i = 1; i <= 6; i++) {
            cp.updateRoundHistory("rock", "win");
        }
        
        // Round 7 is odd, should be random
        String choice = cp.chooseOption();
        assertTrue(
            choice.equals("rock") || choice.equals("paper") || choice.equals("scissors"),
            "Odd rounds >= 5 should choose randomly"
        );
    }
}
