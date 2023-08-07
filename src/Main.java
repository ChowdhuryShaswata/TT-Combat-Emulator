import adapters.*;
import domain.*;
import domain.Character;
import usecases.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Character> characters = new ArrayList<>();
//        characters.add(new Human("Warrior", 1, new Spellbook(/*...*/)));
//        characters.add(new Orc("Brute", 1, new Spellbook(/*...*/)));
        // Create character factories
        CharacterFactory humanFactory = new HumanCharacterFactory();
        CharacterFactory orcFactory = new OrcCharacterFactory();
        StringResourceProvider stringProvider = new DefaultStringResourceProvider();
        Scanner scanner = new Scanner(System.in);

        //Character creation
        CharacterCreationPresenter creationPresenter = new ConsoleCharacterCreationPresenter(stringProvider);
        CharacterCreationController creationController = new ConsoleCharacterCreationController(humanFactory, orcFactory, creationPresenter);
        System.out.println("Create your own characters? Y/N");
        boolean stillCreating = scanner.nextLine().trim().equals("Y");
        while(stillCreating){
        Character newCharacter = creationController.createCharacter();
        if (newCharacter != null){
            characters.add(newCharacter);
        }
        System.out.println("Create more characters? Y/N");
        String lineValue = scanner.nextLine().trim();
        if(!lineValue.equals("Y")){ stillCreating = false;}
        }

        // Create characters using the factories
        if (characters.isEmpty()){
        Character paladin = humanFactory.createCharacter("Sir Paladin", 1, new PaladinArchetype());
        Character druid = orcFactory.createCharacter("Druidic Orc", 1, new DruidArchetype());
        characters.add(paladin);
        characters.add(druid);
        }
        CombatOutputBoundary presenter = new CombatPresenter();
        CombatInputBoundary interactor = new Battle(characters, presenter, stringProvider);
        CombatController controller = new CombatController(interactor);
        controller.start();
    }
}