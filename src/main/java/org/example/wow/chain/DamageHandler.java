package org.example.wow.chain;

public abstract class DamageHandler {

    private DamageHandler next;

    public void setNext(DamageHandler next) {
        this.next = next;
    }

    public final void handleDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Урон не может быть отрицательным");
        }

        int remainingDamage = processDamage(damage);
        if (next != null && remainingDamage > 0) {
            next.handleDamage(remainingDamage);
        }
    }

    protected abstract int processDamage(int damage);
}
