package usecases;
import domain.*;
import domain.Character;

public class OrcCharacterFactory implements CharacterFactory {
    @Override
    public Character createCharacter(String name, int level) {
        return new Orc(name, level, new Spellbook());
    }
    @Override
    public Character createCharacter(String name, int level, Archetype archetype) {
        Spellbook spellbook = archetype.createSpellbook();
        return new Orc(name, level, spellbook);
    }
}