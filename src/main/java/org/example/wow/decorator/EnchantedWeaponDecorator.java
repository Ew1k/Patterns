package org.example.wow.decorator;

public class EnchantedWeaponDecorator extends CharacterDecorator {

    public EnchantedWeaponDecorator(CharacterEquipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return equipment.getDescription() + " + зачарованное оружие";
    }

    @Override
    public int getAttackPower() {
        return equipment.getAttackPower() + 15;
    }
}
