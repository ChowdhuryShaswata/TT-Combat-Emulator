package domain;

public class Character {
    private String name;
    private int healthPoints;
    private int attackPoints;
    private int level;
    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana;
    private int armourClass;

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getArmourClass() {
        return armourClass;
    }

    public int getAbilityModifier() {
        return abilityModifier;
    }

    public Spellbook getSpellbook() {
        return spellbook;
    }

    private int abilityModifier;
    private Spellbook spellbook;

    public Character(String name, int level, int health, int maxHealth, int mana, int maxMana, int armourClass, int abilityModifier, Spellbook spellbook) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.maxHealth = maxHealth;
        this.mana = mana;
        this.maxMana = maxMana;
        this.armourClass = armourClass;
        this.abilityModifier = abilityModifier;
        this.spellbook = spellbook;
    }

    // Getters and setters as needed

    public void castSpell(Spell spell, Character target) {
        if (this.mana >= spell.getManaCost()) {
            System.out.println(this.name + " casts " + spell.getName() + "!");
            this.mana -= spell.getManaCost();
            spell.cast(this, target);
        } else {
            System.out.println(this.name + " does not have enough mana to cast " + spell.getName());
        }
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void attack(Character target) {
        System.out.println(this.name + " attacks " + target.getName() + "!");
        int attackRoll = DiceRoller.rollDice("1d20");
        int damage = 0;

        if (attackRoll >= 10) {
            damage = DiceRoller.rollDice("1d6") + this.attackPoints;
            target.takeDamage(damage);
        } else {
            System.out.println(this.name + " misses the attack!");
        }
    }

    public void takeDamage(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints <= 0) {
            System.out.println(this.name + " has been defeated!");
        } else {
            System.out.println(this.name + " takes " + damage + " damage.");
        }
    }

    public void heal(int amount) {
        this.health = Math.min(this.health + amount, this.maxHealth);
        System.out.println(this.name + " is healed for " + amount + " HP.");
    }
}