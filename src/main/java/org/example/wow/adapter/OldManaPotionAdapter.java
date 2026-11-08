package org.example.wow.adapter;

import org.example.wow.character.GameCharacter;

public class OldManaPotionAdapter implements Consumable {

    private final OldManaPotion oldPotion;

    public OldManaPotionAdapter(OldManaPotion oldPotion) {
        if (oldPotion == null) {
            throw new IllegalArgumentException("Зелье не может быть null");
        }
        this.oldPotion = oldPotion;
    }

    @Override
    public void use(GameCharacter character) {
        if (character == null) {
            throw new IllegalArgumentException("Персонаж не может быть null");
        }
        oldPotion.drinkMana();
        character.restoreMana(oldPotion.getRestoredMana());
    }
}
