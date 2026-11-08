package org.example.wow.chain;

public class ShieldHandler extends DamageHandler {

    private final int shieldValue;

    public ShieldHandler(int shieldValue) {
        if (shieldValue < 0) {
            throw new IllegalArgumentException("Прочность щита не может быть отрицательной");
        }
        this.shieldValue = shieldValue;
    }

    @Override
    protected int processDamage(int damage) {
        int blocked = Math.min(damage, shieldValue);
        System.out.println("Щит поглотил " + blocked + " ед. урона.");
        return damage - blocked;
    }
}
