package org.example.wow.decorator;

import org.example.wow.character.GameCharacter;

public class BasicCharacterEquipment implements CharacterEquipment {

    private final GameCharacter character;

    public BasicCharacterEquipment(GameCharacter character) {
        if (character == null) {
            throw new IllegalArgumentException("Персонаж не может быть null");
        }
        this.character = character;
    }

    @Override
    public String getDescription() {
        return character.getName() + " без дополнительных усилений";
    }

    @Override
    public int getAttackPower() {
        return 10;
    }
}
