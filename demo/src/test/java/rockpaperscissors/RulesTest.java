package rockpaperscissors;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RulesTest {
    private Rules rules;
    
    @BeforeEach
    public void setUp() {
        rules = new Rules();
    }
    
    // Test all win conditions for player 1
    @Test
    public void testRockBeatsScissors() {
        int result = rules.determineWinner("rock", "scissors");
        assertEquals(0, result, "Rock should beat scissors");
    }
    
    @Test
    public void testPaperBeatsRock() {
        int result = rules.determineWinner("paper", "rock");
        assertEquals(0, result, "Paper should beat rock");
    }
    
    @Test
    public void testScissorsBeatsPaper() {
        int result = rules.determineWinner("scissors", "paper");
        assertEquals(0, result, "Scissors should beat paper");
    }
    
    // Test all loss conditions for player 1
    @Test
    public void testScissorsLosesToRock() {
        int result = rules.determineWinner("scissors", "rock");
        assertEquals(1, result, "Scissors should lose to rock");
    }
    
    @Test
    public void testRockLosesToPaper() {
        int result = rules.determineWinner("rock", "paper");
        assertEquals(1, result, "Rock should lose to paper");
    }
    
    @Test
    public void testPaperLosesToScissors() {
        int result = rules.determineWinner("paper", "scissors");
        assertEquals(1, result, "Paper should lose to scissors");
    }
    
    // Test all tie conditions
    @Test
    public void testRockTiesRock() {
        int result = rules.determineWinner("rock", "rock");
        assertEquals(2, result, "Rock should tie with rock");
    }
    
    @Test
    public void testPaperTiesPaper() {
        int result = rules.determineWinner("paper", "paper");
        assertEquals(2, result, "Paper should tie with paper");
    }
    
    @Test
    public void testScissorsTiesScissors() {
        int result = rules.determineWinner("scissors", "scissors");
        assertEquals(2, result, "Scissors should tie with scissors");
    }
}
