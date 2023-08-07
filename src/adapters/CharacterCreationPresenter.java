package adapters;
import domain.Character;

public interface CharacterCreationPresenter {
    void displayMessage(String message);
    String promptForName();
    int promptForLevel();
    String promptForRace();
    String promptForArchetype();
    void displayCharacterCreated(Character character);
}