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
}