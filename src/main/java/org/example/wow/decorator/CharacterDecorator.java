package org.example.wow.decorator;

public abstract class CharacterDecorator implements CharacterEquipment {

    protected final CharacterEquipment equipment;

    protected CharacterDecorator(CharacterEquipment equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("Экипировка не может быть null");
        }
        this.equipment = equipment;
    }
}
