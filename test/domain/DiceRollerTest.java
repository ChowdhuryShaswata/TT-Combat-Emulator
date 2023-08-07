package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiceRollerTest {
    @Test
    public void testDiceRollerRollDice() {
        int result = DiceRoller.rollDice("2d6");
        assertTrue(result >= 2 && result <= 12);
    }
    @Test
    public void testDiceRollerRollDiceWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> DiceRoller.rollDice("invalid"));
    }
}