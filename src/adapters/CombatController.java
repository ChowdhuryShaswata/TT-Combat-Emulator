package adapters;

import usecases.CombatInputBoundary;

import java.util.Scanner;

public class CombatController {
    public static final String BATTLE_STARTS = "Battle starts!";
    private CombatInputBoundary interactor;
    private Scanner scanner;

    public CombatController(CombatInputBoundary interactor) {
        this.interactor = interactor;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println(BATTLE_STARTS);
        interactor.startBattle();
    }

    // Implement methods to convert user input and call appropriate interactor methods
}

