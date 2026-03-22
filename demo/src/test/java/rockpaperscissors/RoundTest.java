package rockpaperscissors;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RoundTest {
    
    @Test
    public void testRoundCreation() {
        Round round = new Round("rock", "win");
        assertEquals("rock", round.getPC(), "Round should store correct player choice");
        assertEquals("win", round.getRes(), "Round should store correct result");
    }
    
    @Test
    public void testRockBeatsScissors() {
        Round round = new Round("rock", "win");
        assertEquals("scissors", round.beats(), "Rock should beat scissors");
    }
    
    @Test
    public void testPaperBeatsRock() {
        Round round = new Round("paper", "win");
        assertEquals("rock", round.beats(), "Paper should beat rock");
    }
    
    @Test
    public void testScissorsBeatsPaper() {
        Round round = new Round("scissors", "win");
        assertEquals("paper", round.beats(), "Scissors should beat paper");
    }
    
    @Test
    public void testRockLosesToPaper() {
        Round round = new Round("rock", "lost");
        assertEquals("paper", round.getsBeatBy(), "Rock should lose to paper");
    }
    
    @Test
    public void testPaperLosesToScissors() {
        Round round = new Round("paper", "lost");
        assertEquals("scissors", round.getsBeatBy(), "Paper should lose to scissors");
    }
    
    @Test
    public void testScissorsLosesToRock() {
        Round round = new Round("scissors", "lost");
        assertEquals("rock", round.getsBeatBy(), "Scissors should lose to rock");
    }
    
    @Test
    public void testMultipleRoundsIndependent() {
        Round round1 = new Round("rock", "win");
        Round round2 = new Round("paper", "lost");
        
        assertEquals("rock", round1.getPC());
        assertEquals("paper", round2.getPC());
        assertEquals("win", round1.getRes());
        assertEquals("lost", round2.getRes());
    }
}
