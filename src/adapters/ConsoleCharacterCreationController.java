package adapters;

import domain.Archetype;
import domain.DruidArchetype;
import domain.PaladinArchetype;
import usecases.CharacterFactory;
import domain.Character;

public class ConsoleCharacterCreationController implements CharacterCreationController {
    private CharacterFactory humanFactory;
    private CharacterFactory orcFactory;
    private CharacterCreationPresenter presenter;

    public ConsoleCharacterCreationController(CharacterFactory humanFactory, CharacterFactory orcFactory,
                                              CharacterCreationPresenter presenter) {
        this.humanFactory = humanFactory;
        this.orcFactory = orcFactory;
        this.presenter = presenter;
    }

    @Override
    public Character createCharacter() {
        presenter.displayMessage("Welcome to character creation!");
        String race = presenter.promptForRace();
        String archetype = presenter.promptForArchetype();
        String name = presenter.promptForName();
        int level = presenter.promptForLevel();

        CharacterFactory factory;
        if (race.equalsIgnoreCase("human")) {
            factory = humanFactory;
        } else if (race.equalsIgnoreCase("orc")) {factory = orcFactory;} else {
            presenter.displayMessage("Invalid race. Character creation aborted.");
            return null;
        }

        Character character;
        Archetype selectedArchetype = createArchetype(archetype);
        if (selectedArchetype != null) {
            character = factory.createCharacter(name, level, selectedArchetype);
        } else{character = factory.createCharacter(name, level);}
        presenter.displayCharacterCreated(character);
        return character;
    }
    private Archetype createArchetype(String archetype) {
        if(archetype.equals("Paladin")){
            return new PaladinArchetype();
        } else if(archetype.equals("Druid")){
            return new DruidArchetype();
        } else{
        return null;}
    }
}