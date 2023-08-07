package domain;

public class DruidArchetype implements Archetype {
    @Override
    public Spellbook createSpellbook() {
        Spell thornWhip = new OffenseSpell("Thorn Whip", "Deals 1d20 damage", 8,"1d20");
        Spell pounce = new OffenseSpell("Pounce", "Deals 5d2 damage",5, "5d2");

        Spellbook spellbook = new Spellbook();
        spellbook.addSpell(thornWhip);
        spellbook.addSpell(pounce);

        return spellbook;
    }
}