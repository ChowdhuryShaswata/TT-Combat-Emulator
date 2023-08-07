package adapters;
import domain.Character;
import usecases.StringResourceProvider;
import java.util.Scanner;

public class ConsoleCharacterCreationPresenter implements CharacterCreationPresenter {
    private StringResourceProvider stringResourceProvider;
    private Scanner scanner;
    public ConsoleCharacterCreationPresenter(StringResourceProvider stringResourceProvider){
        this.stringResourceProvider = stringResourceProvider;
        this.scanner = new Scanner(System.in);
    }
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
    @Override
    public String promptForName() {
        displayMessage(stringResourceProvider.getNamePrompt());
        return scanner.nextLine().trim();
    }
    @Override
    public int promptForLevel() {
        displayMessage(stringResourceProvider.getLevelPrompt());
        int level = scanner.nextInt();
        scanner.nextLine().trim();
       return level;
    }
    @Override
    public String promptForRace() {
        displayMessage(stringResourceProvider.getRacePrompt());
        return scanner.nextLine().trim();
    }
    @Override
    public String promptForArchetype() {
        displayMessage(stringResourceProvider.getArchetypePrompt());
        return scanner.nextLine().trim();
    }
    @Override
    public void displayCharacterCreated(Character character) {
        String msg = "Your character is: " + character.getName() + " with health" + Integer.toString(character.getHealth()) + " and mana " + Integer.toString(character.getMana());
        displayMessage(msg);
    }
}