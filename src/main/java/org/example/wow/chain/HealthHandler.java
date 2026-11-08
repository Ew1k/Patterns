package org.example.wow.chain;

import org.example.wow.character.GameCharacter;

public class HealthHandler extends DamageHandler {

    private final GameCharacter character;

    public HealthHandler(GameCharacter character) {
        if (character == null) {
            throw new IllegalArgumentException("Персонаж не может быть null");
        }
        this.character = character;
    }

    @Override
    protected int processDamage(int damage) {
        character.takeDamage(damage);
        return 0;
    }
}
