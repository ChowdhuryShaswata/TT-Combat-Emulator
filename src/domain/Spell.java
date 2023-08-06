package domain;

public abstract class Spell {
    private String name;
    private String description;
    private int manaCost;

    public Spell(String name, String description, int manaCost) {
        this.name = name;
        this.description = description;
        this.manaCost = manaCost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getManaCost() {
        return manaCost;
    }

    // Abstract method to be implemented in child classes
    public abstract void cast(Character caster, Character target);
}