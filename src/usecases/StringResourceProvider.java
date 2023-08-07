package usecases;

public interface StringResourceProvider {
    String getBattleStarts();
    String getRound(int roundNumber);
    String getTurns(String characterName);
    String getAvailableActions();
    String getSkippingTurn(String characterName);
    String getInvalidAction();
    String getAvailableSpells();
    String getTypeSpellName();
    String getInvalidSpell();
    String getBattleEnds();

    String getInvalidTarget();
}

