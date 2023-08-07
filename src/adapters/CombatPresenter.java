package adapters;

import usecases.CombatOutputBoundary;
import domain.Character;

import java.util.List;

public class CombatPresenter implements CombatOutputBoundary {
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

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

