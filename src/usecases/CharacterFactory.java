package usecases;

import domain.Archetype;
import domain.Character;

/**
 * Represents a factory for creating characters with different archetypes.
 * This interface provides methods to create characters with or without an archetype.
 */
public interface CharacterFactory {
    /**
     * Creates a character with the given name and level.
     * @param name The name of the character.
     * @param level The level of the character.
     * @return The created character.
     */
    Character createCharacter(String name, int level);
    /**
     * Creates a character with the given name, level, and archetype.
     *
     * @param name The name of the character.
     * @param level The level of the character.
     * @param archetype The archetype to assign to the character.
     * @return The created character with the specified archetype.
     */
    Character createCharacter(String name, int level, Archetype archetype);
}