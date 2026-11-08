package org.example.wow.character;

import org.example.wow.strategy.CombatStrategy;
import org.example.wow.strategy.MeleeCombatStrategy;

public class GameCharacter {

    private final String name;
    private final String race;
    private final String characterClass;
    private final String weapon;
    private int health;
    private int mana;
    private CombatStrategy combatStrategy;

    public GameCharacter(String name, String race, String characterClass,
                         String weapon, int health, int mana) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.weapon = weapon;
        this.health = health;
        this.mana = mana;
        this.combatStrategy = new MeleeCombatStrategy();
    }

    public void setCombatStrategy(CombatStrategy combatStrategy) {
        if (combatStrategy == null) {
            throw new IllegalArgumentException("combatStrategy не может быть null");
        }
        this.combatStrategy = combatStrategy;
    }

    public void attack() {
        combatStrategy.attack(name, weapon);
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("damage не может быть отрицательным");
        }
        health = Math.max(0, health - damage);
        System.out.println(name + " получает " + damage + " ед. урона.");
    }

    public void restoreMana(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Количество маны не может быть отрицательным");
        }
        mana += amount;
    }

    public void showInfo() {
        System.out.println("Персонаж: " + name);
        System.out.println("Раса: " + race);
        System.out.println("Класс: " + characterClass);
        System.out.println("Оружие: " + weapon);
        System.out.println("Здоровье: " + health);
        System.out.println("Мана: " + mana);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public String getWeapon() {
        return weapon;
    }
}
