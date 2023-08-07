import adapters.CombatController;
import adapters.CombatPresenter;
import adapters.DefaultStringResourceProvider;
import domain.Human;
import domain.Orc;
import domain.Spellbook;
import usecases.Battle;
import usecases.CombatInputBoundary;
import usecases.CombatOutputBoundary;
import domain.Character;
import usecases.StringResourceProvider;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();
        characters.add(new Human("Warrior", 1, new Spellbook(/*...*/)));
        characters.add(new Orc("Brute", 1, new Spellbook(/*...*/)));

        CombatOutputBoundary presenter = new CombatPresenter();
        StringResourceProvider stringProvider = new DefaultStringResourceProvider();
        CombatInputBoundary interactor = new Battle(characters, presenter, stringProvider);
        CombatController controller = new CombatController(interactor);

        controller.start();
    }
}
