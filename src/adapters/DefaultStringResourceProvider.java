package adapters;

import usecases.StringResourceProvider;
import frameworks.StringResource;

public class DefaultStringResourceProvider implements StringResourceProvider {
    @Override
    public String getBattleStarts() {
        return StringResource.BATTLE_STARTS;
    }

    @Override
    public String getRound(int roundNumber) {
        return String.format(StringResource.ROUND, roundNumber);
    }

    @Override
    public String getTurns(String characterName) {
        return String.format(StringResource.TURNS, characterName);
    }

    @Override
    public String getAvailableActions() {
        return StringResource.AVAILABLE_ACTIONS;
    }

    @Override
    public String getSkippingTurn(String characterName) {
        return String.format(StringResource.SKIPPING_TURN, characterName);
    }

    @Override
    public String getInvalidAction() {
        return StringResource.INVALID_ACTION;
    }

    @Override
    public String getAvailableSpells() {
        return StringResource.AVAILABLE_SPELLS;
    }

    @Override
    public String getTypeSpellName() {
        return StringResource.TYPE_SPELL_NAME;
    }

    @Override
    public String getInvalidSpell() {
        return StringResource.INVALID_SPELL;
    }

    @Override
    public String getBattleEnds() {
        return StringResource.BATTLE_ENDS;
    }

    @Override
    public String getInvalidTarget() {
        return StringResource.INVALID_TARGET;
    }

    @Override
    public String getNamePrompt() {
        return StringResource.NAME_PROMPT;
    }

    @Override
    public String getRacePrompt() {
        return StringResource.RACE_PROMPT;
    }

    @Override
    public String getLevelPrompt() {
        return StringResource.LEVEL_PROMPT;
    }

    @Override
    public String getArchetypePrompt() {
        return StringResource.ARCHETYPE_PROMPT;
    }
}