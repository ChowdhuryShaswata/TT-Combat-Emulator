package adapters;

import usecases.CombatOutputBoundary;
import domain.Character;

import java.util.List;
/**
 * Presents information to the user during the battle scenario.
 * This class displays messages and character stats to the user.
 */
public class CombatPresenter implements CombatOutputBoundary {
    /**
     * Displays a message to the user.
     * @param message The message to be displayed.
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
    /**
     * Displays the stats of a character to the user.
     * @param character The character whose stats will be displayed.
     */
    @Override
    public void displayCharacterStats(Character character) {
        System.out.println(character.getName() + " - HP: " + character.getHealth());
    }
    @Override
    public void displayCharacterList(List<Character> characters) {
        System.out.println("The characters on the battlefield are:");
        for (Character character: characters) {
            System.out.println(character.getName());
        }
    }
}