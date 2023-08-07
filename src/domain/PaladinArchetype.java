package domain;

public class PaladinArchetype implements Archetype {
    @Override
    public Spellbook createSpellbook() {
        Spell searingSmite = new OffenseSpell("Searing Smite", "Deals 3d6 damage", 10, "3d6");
        Spell layOnHands = new RecoverySpell("Lay On Hands", "Heals by 2d4", 5, "2d4");

        Spellbook spellbook = new Spellbook();
        spellbook.addSpell(searingSmite);
        spellbook.addSpell(layOnHands);

        return spellbook;
    }
}