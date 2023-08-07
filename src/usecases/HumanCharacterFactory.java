package usecases;
import domain.Archetype;
import domain.Human;
import domain.Spellbook;
import domain.Character;

public class HumanCharacterFactory implements CharacterFactory {
    @Override
    public Character createCharacter(String name, int level) {
        return new Human(name, level, new Spellbook());
    }
    @Override
    public Character createCharacter(String name, int level, Archetype archetype) {
        Spellbook spellbook = archetype.createSpellbook();
        return new Human(name, level, spellbook);
    }
}