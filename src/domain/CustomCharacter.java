package domain;

public class CustomCharacter extends Character {
    private int customMaxHealth;
    private int customMaxMana;
    private int customArmourClass;
    private int customAbilityModifier;


    public CustomCharacter(String name, int level, Spellbook spellbook,
                           int customMaxHealth, int customMaxMana,
                           int customArmourClass, int customAbilityModifier) {
        super(name, level, spellbook);
        this.customMaxHealth = customMaxHealth;
        this.customMaxMana = customMaxMana;
        this.customArmourClass = customArmourClass;
        this.customAbilityModifier = customAbilityModifier;
        initializeStats();
    }

    @Override
    public void initializeStats() {
        this.maxHealth = customMaxHealth;
        this.maxMana = customMaxMana;
        this.armourClass = customArmourClass;
        this.abilityModifier = customAbilityModifier;
        this.health = maxHealth;
        this.mana = maxMana;
        this.attackPoints = customAbilityModifier;
    }
}