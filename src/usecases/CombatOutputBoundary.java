package usecases;
import domain.Character;

import java.util.List;

public interface CombatOutputBoundary {
    void displayMessage(String message);
    void displayCharacterStats(Character character);
    // Other methods for presenting information to the user
    void displayCharacterList(List<Character> characters);
}
