package adapters;

import usecases.CombatInputBoundary;

import java.util.Scanner;
/**
 * Controls the user interactions in the battle scenario.
 * This class handles user input and triggers actions in the combat interactor.
 */
public class CombatController {
    public static final String BATTLE_STARTS = "Battle starts!";
    private CombatInputBoundary interactor;
    private Scanner scanner;
    /**
     * Initializes a new instance of the CombatController class.
     * @param interactor The combat interactor to handle user actions.
     */
    public CombatController(CombatInputBoundary interactor) {
        this.interactor = interactor;
        this.scanner = new Scanner(System.in);
    }
    /**
     * Starts the battle and manages user interactions.
     */
    public void start() {
        System.out.println(BATTLE_STARTS);
        interactor.startBattle();
    }
}