package usecases;

import domain.DiceRoller;
import domain.Character;

public class CharacterService {
    public void attack(Character attacker, Character target) {
        int attackRoll = DiceRoller.rollDice("1d20") + attacker.getAbilityModifier();
        int damage = 0;

        if (attackRoll >= target.getArmourClass()) {
            damage = DiceRoller.rollDice("1d6") + attacker.getAbilityModifier();
            target.takeDamage(damage);
        } else {
            System.out.println(attacker.getName() + " misses the attack!");
        }
    }
}
