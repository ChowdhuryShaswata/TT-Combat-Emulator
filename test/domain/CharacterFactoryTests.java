package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.CharacterFactory;
import usecases.HumanCharacterFactory;
import usecases.OrcCharacterFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
class CharacterFactoryTests {
    private Archetype fakeArchetype;
    private CharacterFactory humanFactory;
    private CharacterFactory orcFactory;

    @BeforeEach
    void setup() {
        fakeArchetype = new FakeArchetype();
        humanFactory = new HumanCharacterFactory();
        orcFactory = new OrcCharacterFactory();
    }

    @Test
    void testCreateCharacterWithoutArchetype() {
        Character humanCharacter = humanFactory.createCharacter("Human1", 1);

        assertEquals("Human1", humanCharacter.getName());
        // Verify other properties here
    }

    @Test
    void testCreateCharacterWithArchetype() {
        Character humanCharacter = humanFactory.createCharacter("Human2", 1, fakeArchetype);

        assertEquals("Human2", humanCharacter.getName());
        // Verify other properties here
    }
    @Test
    void testCreateOrcCharacterWithArchetype() {
        Character orcCharacter = orcFactory.createCharacter("Orc1", 1, fakeArchetype);

        assertEquals("Orc1", orcCharacter.getName());
        // Verify other properties here
    }
    // Fake Archetype for testing purposes
    private static class FakeArchetype implements Archetype {
        @Override
        public Spellbook createSpellbook() {
            Spellbook spellbook = new Spellbook();
            spellbook.addSpell(new OffenseSpell("Test Spell", "Description", 10,"1d6"));
            return spellbook;
        }
    }
}