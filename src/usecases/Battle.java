package usecases;

import domain.*;
import domain.Character;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Represents a simulated battle scenario in a tabletop RPG.
 * This class orchestrates the combat interactions between characters.
 */
public class Battle implements CombatInputBoundary{
    private List<Character> characters;
    private int roundNumber;
    private Scanner scanner;
    private CombatOutputBoundary presenter;

    private StringResourceProvider stringResourceProvider;

    private boolean battleIsOver;

    /**
     * Initializes a new instance of the Battle class.
     *
     * @param characters List of characters participating in the battle.
     * @param presenter The presenter to display information to the user.
     * @param stringResourceProvider The provider for string resources.
     */
    public Battle(List<Character> characters, CombatOutputBoundary presenter, StringResourceProvider stringResourceProvider) {
        this.characters = characters;
        this.roundNumber = 1;
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
        battleIsOver = false;
        this.stringResourceProvider = stringResourceProvider;
    }

    public void setBattleIsOver(boolean battleIsOver) {
        this.battleIsOver = battleIsOver;
    }

    /**
     * Starts the battle scenario, executing combat turns for each character.
     */
    public void startBattle() {
        presenter.displayMessage(stringResourceProvider.getBattleStarts());
        initializeCharacters();
        printBattleState();
        Collections.shuffle(characters);


        while (!isBattleOver()) {
            for (Character character : characters) {
                if (character.isAlive()) {
                    presenter.displayMessage(stringResourceProvider.getRound(roundNumber));
                    presenter.displayMessage(stringResourceProvider.getTurns(character.getName()));
                    takeCharacterAction(character);
                    printBattleState();
                }
            }
            roundNumber++;
        }
        presenter.displayMessage(stringResourceProvider.getBattleEnds());
    }

    private void initializeCharacters() {
        for (Character character : characters) {
            character.initializeStats();
        }
    }

    private boolean isBattleOver() {
        // Implement battle end conditions
        // For example, when all characters of one side are defeated
        // or when the user types "exit"
        return battleIsOver;
    }

    private void takeCharacterAction(Character character) {
        presenter.displayMessage(stringResourceProvider.getAvailableActions());
        String input = scanner.nextLine().trim();

        if (input.startsWith("attack")) {
            String targetName = input.substring("attack ".length());
            Character target = findCharacterByName(targetName);
            if (target != null && target.isAlive()) {
                character.attack(target);
            } else {
                presenter.displayMessage(stringResourceProvider.getInvalidTarget());
            }
        } else if (input.equals("spellbook")) {
            showSpellbookMenu(character);
            // Handle spell casting logic
            // ...

        } else if (input.equals("skip")) {
            presenter.displayMessage(stringResourceProvider.getSkippingTurn(character.getName()));
        } else if (input.equals("info")) {
            printBattleState();
        } else if (input.equals("exit")) {
            setBattleIsOver(true);
        } else {
            presenter.displayMessage(stringResourceProvider.getInvalidAction());
        }
    }

    private void showSpellbook(List<Spell> listOfSpells){
        presenter.displayMessage(stringResourceProvider.getAvailableSpells());
        for (Spell spell:listOfSpells) {
            String spellPrint = spell.getName() + " " + Integer.toString(spell.getManaCost());
            System.out.println(spellPrint);
        }
    }

    private void showSpellbookMenu(Character character){
        List<Spell> spellList = character.getSpellbook().getSpells();
        showSpellbook(spellList);
        ArrayList<String> spellNames = new ArrayList<>();
        HashMap<String, Spell> spellDictionary = new HashMap<String, Spell>();
        for (Spell spell:spellList) {
            spellNames.add(spell.getName());
            spellDictionary.put(spell.getName(), spell);
        }
        String spellInput = scanner.nextLine().trim();
        if (spellInput.equals("back")){
            takeCharacterAction(character);
        }else if(spellNames.contains(spellInput)){
            presenter.displayCharacterList(characters);
            String targetInput = scanner.nextLine().trim();
            Character target = findCharacterByName(targetInput);
            //If target not null, character casts spell at target.
            if(target != null) {
                character.castSpell(spellDictionary.get(spellInput), target);
            }else {
                presenter.displayMessage(stringResourceProvider.getInvalidTarget());
                takeCharacterAction(character);
            }
        } else{
            presenter.displayMessage("Invalid spell name.");
        }
    }

    private void printBattleState() {
        presenter.displayMessage(stringResourceProvider.getRound(roundNumber));
        for (Character character : characters) {
            if (character.isAlive()) {
                presenter.displayCharacterStats(character);
            }
        }
    }

    private Character findCharacterByName(String name) {
        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }
        return null;
    }
}