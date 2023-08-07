package domain;

public class RecoverySpell extends Spell {
    private String healingAmount;

    public RecoverySpell(String name, String description, int manaCost, String healingAmount) {
        super(name, description, manaCost);
        this.healingAmount = healingAmount;
    }

    public String getHealingAmount() {
        return healingAmount;
    }

    @Override
    public void cast(Character caster, Character target) {
        int heal = DiceRoller.rollDice(healingAmount);
        target.heal(heal);
    }
}