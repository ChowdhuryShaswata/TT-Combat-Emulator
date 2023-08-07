package domain;

public class Orc extends Character {
    public Orc(String name, int level, Spellbook spellbook) {
        super(name, level, spellbook);
        initializeStats();
    }
    @Override
    public void initializeStats() {
        this.maxHealth = 30;
        this.maxMana = 15;
        this.armourClass = 12;
        this.abilityModifier = 3;
        this.health = maxHealth;
        this.mana = maxMana;
    }
}
