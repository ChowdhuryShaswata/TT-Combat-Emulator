package domain;

import java.util.*;

public class Spellbook {
    private List<Spell> spells;

    public Spellbook(List<Spell> spells) {
        this.spells = spells;
    }
    public Spellbook() {
        this.spells = new ArrayList<Spell>();
        };

    public List<Spell> getSpells() {
        return spells;
    }

    /**
     * Add spells to this spellbook.
     * @param spell
     */
    public void addSpell(Spell spell){
        spells.add(spell);
    }
}