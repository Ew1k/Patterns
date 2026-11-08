package org.example.wow.decorator;

public class BlessingDecorator extends CharacterDecorator {

    public BlessingDecorator(CharacterEquipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return equipment.getDescription() + " + благословение паладина";
    }

    @Override
    public int getAttackPower() {
        return equipment.getAttackPower() + 5;
    }
}
