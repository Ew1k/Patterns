package org.example.wow.strategy;

public class MeleeCombatStrategy implements CombatStrategy {

    @Override
    public void attack(String characterName, String weapon) {
        System.out.println(characterName + " атакует в ближнем блю с помощью: " + weapon);
    }
}
