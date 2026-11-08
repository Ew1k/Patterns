package org.example.wow.strategy;

public class MagicCombatStrategy implements CombatStrategy {

    @Override
    public void attack(String characterName, String weapon) {
        System.out.println(characterName + " Кастует заклинание с помощью: " + weapon);
    }
}
