package domain;

import org.junit.Before;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class SpellTest {
    Character caster;
    Character target;
    @Before
    void setup(){
        caster = new CustomCharacter("Caster", 2, new Spellbook(), 20, 20, 1, 4);
        target = new CustomCharacter("Caster", 2, new Spellbook(), 20, 20, 1, 4);
    }
    @Test
    public void testOffenseSpellCast() {
        setup();
        Spell spell = new OffenseSpell("Fireball", "A fiery explosion", 10, "2d6");

        int initialHealth = target.getHealth();
        spell.cast(caster, target);
        int newHealth = target.getHealth();

        assertTrue(newHealth < initialHealth);
    }
    @Test
    public void testRecoverySpellCast() {
        setup();
        Spell spell = new RecoverySpell("Heal", "A healing spell", 5, "1d6");

        target.takeDamage(5);
        int initialHealth = target.getHealth();
        int initialMana = caster.getMana();
        caster.castSpell(spell, target);
//        spell.cast(caster, target);
        int newHealth = target.getHealth();
        int newMana = caster.getMana();

        assertTrue(newHealth > initialHealth);
        assertEquals(newMana, initialMana - spell.getManaCost());
    }
}