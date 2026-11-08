package org.example.wow.strategy;

public class RangeCombatStrategy implements CombatStrategy {

    @Override
    public void attack(String characterName, String weapon) {
        System.out.println(characterName + " Выстрел используя: " + weapon);
    }
}
