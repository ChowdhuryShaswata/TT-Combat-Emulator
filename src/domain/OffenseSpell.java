package domain;

public class OffenseSpell extends Spell {
    private String spellDamage;

    public OffenseSpell(String name, String description, int manaCost, String spellDamage) {
        super(name, description, manaCost);
        this.spellDamage = spellDamage;
    }

    public String getSpellDamage() {
        return spellDamage;
    }

    @Override
    public void cast(Character caster, Character target) {
        int damage = DiceRoller.rollDice(spellDamage);
        target.takeDamage(damage);
    }
}

