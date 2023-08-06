package domain;

import java.util.List;

public class Spellbook {
    private List<Spell> spells;

    public Spellbook(List<Spell> spells) {
        this.spells = spells;
    }

    public List<Spell> getSpells() {
        return spells;
    }

}