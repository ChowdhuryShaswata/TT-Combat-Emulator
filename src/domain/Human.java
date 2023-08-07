package domain;

public class Human extends Character {
    public Human(String name, int level, Spellbook spellbook) {
        super(name, level, spellbook);
        initializeStats();
    }

    @Override
    public void initializeStats() {
        this.maxHealth = 20;
        this.maxMana = 20;
        this.armourClass = 10;
        this.abilityModifier = 5;
        this.health = maxHealth;
        this.mana = maxMana;
        this.attackPoints = 7;
    }
}
