package org.example.wow.chain;

public class ArmorHandler extends DamageHandler {

    private final int armorValue;

    public ArmorHandler(int armorValue) {
        if (armorValue < 0) {
            throw new IllegalArgumentException("Защита брони не может быть отрицательной");
        }
        this.armorValue = armorValue;
    }

    @Override
    protected int processDamage(int damage) {
        int blocked = Math.min(damage, armorValue);
        System.out.println("Броня поглотила " + blocked + " ед. урона.");
        return damage - blocked;
    }
}
