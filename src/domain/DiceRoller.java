package domain;
public class DiceRoller {
    public static int rollDice(String diceNotation) {
        int sum = 0;
        String[] parts = diceNotation.split("d");
        int numDice = Integer.parseInt(parts[0]);
        int dieSize = Integer.parseInt(parts[1]);

        Die die = new Die(dieSize);

        for (int i = 0; i < numDice; i++) {
            sum += die.roll();
        }
        return sum;
    }
}