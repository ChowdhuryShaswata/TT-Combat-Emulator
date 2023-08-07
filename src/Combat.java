import java.util.Scanner;
import domain.Character;

public class Combat {
    private Character player;
    private Character enemy;
    private Scanner scanner;

    public Combat(Character player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Combat begins!");
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            playerTurn();
            if (enemy.getHealth() > 0) {
                enemyTurn();
            }
        }
        System.out.println("Combat ends!");
    }

    private void playerTurn() {
        System.out.println("Your turn. What do you want to do? (Type 'attack')");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("attack")) {
            player.attack(enemy);
        } else {
            System.out.println("Invalid action. You lose your turn.");
        }
    }

    private void enemyTurn() {
        enemy.attack(player);
    }

    public static void main(String[] args) {
//        Character player = new Character("Player", 100, 20);
//        Character enemy = new Character("Enemy", 80, 15);
//
//        Combat combat = new Combat(player, enemy);
//        combat.start();
    }
}

